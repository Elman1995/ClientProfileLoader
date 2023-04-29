package org.client.ClientProfileService.service.producer;

import lombok.extern.slf4j.Slf4j;
import org.client.ClientProfileService.dto.AddressDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Producer {

    private final KafkaTemplate<String, AddressDto> kafkaTemplate;

    public Producer(KafkaTemplate<String, AddressDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(AddressDto addressDto) {
        if (addressDto != null) {
            Message<AddressDto> message = MessageBuilder
                    .withPayload(addressDto)
                    .setHeader(KafkaHeaders.TOPIC, "load")
                    .build();

            kafkaTemplate.send(message);

            log.info("The message has been sent");
        } else {
            log.warn("Object is null");
        }
    }
}
