package org.client.ClientProfileService.config;

import lombok.AllArgsConstructor;
import org.client.ClientProfileService.masking.MaskingService;
import org.client.ClientProfileService.masking.impl.MaskingServiceImpl;
import org.client.ClientProfileService.repositories.IndividualRepository;
import org.client.ClientProfileService.service.AddressService;
import org.client.ClientProfileService.service.IndividualService;
import org.client.ClientProfileService.service.impl.AddressServiceImpl;
import org.client.ClientProfileService.util.MappingUtils;
/*import org.client.masking.MaskingService;
import org.client.masking.impl.MaskingServiceImpl;
import org.client.repositories.IndividualRepository;
import org.client.service.AddressService;
import org.client.service.IndividualService;
import org.client.service.impl.AddressServiceImpl;
import org.client.util.MappingUtils;*/
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
@AllArgsConstructor
public class ServiceConfig {

    private final IndividualRepository individualRepository;
    private final MappingUtils mappingUtils;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public AddressService addressService(IndividualService individualService) {
        return new AddressServiceImpl(individualService, individualRepository, mappingUtils);
    }

    @Bean
    public MaskingService maskingService() {
        return new MaskingServiceImpl();
    }
}
