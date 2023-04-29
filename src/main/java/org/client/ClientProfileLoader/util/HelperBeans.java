package org.client.ClientProfileLoader.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class HelperBeans {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(2))
                .setReadTimeout(Duration.ofSeconds(3))
                .build();
    }
    @Bean("nullFields")
    public StringBuilder getStringBuilderNullFields() {
        return new StringBuilder();
    }

    @Bean("comments")
    public StringBuilder getStringBuilderComments() {
        return new StringBuilder();
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }


}
