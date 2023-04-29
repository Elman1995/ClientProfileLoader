package org.client.ClientProfileLoader.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.client.ClientProfileLoader.entity.Individual;
import org.client.ClientProfileLoader.entity.RFPassport;
import org.client.ClientProfileLoader.service.IndividualServiceLoader;
import org.client.ClientProfileLoader.util.DataInfoHandler;
import org.client.ClientProfileLoader.util.IndividualWithSuchICPExists;
import org.client.ClientProfileLoader.util.NoSuchIndividualException;
import org.client.ClientProfileLoader.util.PassportException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for individual
 */

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api")
public class IndividualRESTController {

    private IndividualServiceLoader individualService;

    //TODO Для работы с IMB раскоментировать строчки ниже
//    private JmsTemplate jmsTemplate;
//    @Value("${ibm.mq.queueName}")
//    private String queueName;

//    @Autowired
//    public void setJmsTemplate(JmsTemplate jmsTemplate) {
//        this.jmsTemplate = jmsTemplate;
//    }

    @GetMapping("/clients/{icp}")
    public ResponseEntity<Individual> getIndividual(@PathVariable("icp") String icp) {
        Individual individual = individualService.findByIcp(icp);

        if (individual == null) {
            throw new NoSuchIndividualException("There is no individual with icp = " + icp + " in Database");
        }
        log.info("Getting individual");
        return new ResponseEntity<>(individual, HttpStatus.OK);
    }

    @PostMapping("/clients")
    public ResponseEntity<DataInfoHandler> saveIndividual(@RequestBody Individual individual) throws JsonProcessingException {
        try {
            individualService.saveIndividual(individual);
            log.info("Saving individual");

            //ObjectMapper mapper = new ObjectMapper();
            //jmsTemplate.convertAndSend(queueName, mapper.writeValueAsString(individual));

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            throw new IndividualWithSuchICPExists("Individual with such icp exists");
        }
    }
    @PutMapping("/clients/{icp}")
    public ResponseEntity<DataInfoHandler> saveRFPassport(@RequestBody RFPassport rfPassport,
                                                          @PathVariable("icp") String icp) {
        try {
            Individual individual = individualService.findByIcp(icp);
            individual.setRfPassport(rfPassport);
            log.info("Saving RF Passport");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            throw new PassportException("Invalid passport data");
        }
    }


}
