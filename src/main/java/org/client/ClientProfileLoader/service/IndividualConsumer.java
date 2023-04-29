package org.client.ClientProfileLoader.service;//package org.client.service;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.github.sonus21.rqueue.core.RqueueMessageSender;
//import lombok.AllArgsConstructor;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.client.dto.ContactUpdateDto;
//import org.client.util.EmailPhoneValidator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//@RequiredArgsConstructor
//public class IndividualConsumer {
//    private final ObjectMapper objectMapper;
//    private final EmailPhoneValidator emailPhoneValidator;
//    private final @NonNull RqueueMessageSender rqueueMessageSender;
//    @Value("${email.queue.name}")
//    private String emailQueueName;
//    @Value("${email.queue.delay}")
//    private Long emailDelay;
//    @Value("${phoneNumber.queue.name}")
//    private String phoneNumberQueueName;
//    @Value("${phoneNumber.queue.delay}")
//    private Long phoneNumberDelay;
//
//    @KafkaListener(topics = "update", groupId = "myGroup")
//    public void updateContact(String msg) throws JsonProcessingException {
//        ContactUpdateDto contactUpdateDto = objectMapper.readValue(msg, ContactUpdateDto.class);
//        if (emailPhoneValidator.validateEmail(contactUpdateDto.getContact())) {
//            log.info("Updating email");
//            rqueueMessageSender.enqueueIn(emailQueueName, contactUpdateDto, emailDelay);
//        } else if (emailPhoneValidator.validatePhoneNumber(contactUpdateDto.getContact())) {
//            log.info("Updating phone number");
//            rqueueMessageSender.enqueueIn(phoneNumberQueueName, contactUpdateDto, phoneNumberDelay);
//        }
//    }
//}
