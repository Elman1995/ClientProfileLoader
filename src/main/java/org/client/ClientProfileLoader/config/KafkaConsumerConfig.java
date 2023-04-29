package org.client.ClientProfileLoader.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.client.ClientProfileLoader.dto.AddressDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@Component
public class KafkaConsumerConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessage(ConsumerRecord<String, AddressDto> record) {
        LOGGER.info(String.format("Object %s received", record.value()));
    }
}
