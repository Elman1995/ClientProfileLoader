package org.client.ClientProfileLoader.config;

import lombok.AllArgsConstructor;
import org.client.ClientProfileLoader.repositories.IndividualRepository;
import org.client.ClientProfileLoader.service.AddressService;
import org.client.ClientProfileLoader.service.IndividualServiceLoader;
import org.client.ClientProfileLoader.service.impl.AddressServiceImpl;
import org.client.ClientProfileLoader.service.MaskingService;
import org.client.ClientProfileLoader.service.impl.MaskingServiceImpl;
import org.client.ClientProfileLoader.util.MappingUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class ServiceConfigLoader {

    private final MappingUtils mappingUtils;

    @Bean
    public AddressService addressService(IndividualServiceLoader individualServiceLoader, IndividualRepository individualRepository) {
        return new AddressServiceImpl(individualServiceLoader, individualRepository, mappingUtils);
    }

    @Bean
    public MaskingService maskingService() {
        return new MaskingServiceImpl();
    }
}
