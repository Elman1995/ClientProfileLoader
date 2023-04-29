package org.client.ClientProfileLoader.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.client.ClientProfileLoader.config.KafkaConsumerConfig;
import org.client.ClientProfileLoader.dto.AddressDto;
import org.client.ClientProfileLoader.dto.DocumentDto;
import org.client.ClientProfileLoader.dto.IndividualDto;
import org.client.ClientProfileLoader.entity.RFPassport;
import org.client.ClientProfileLoader.service.IndividualServiceLoader;
import org.client.ClientProfileLoader.service.ListnersTopics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.lang.reflect.Field;
import java.util.Collection;


@Service
@RequiredArgsConstructor
public class ListnersTopicsImp implements ListnersTopics {

    private final IndividualServiceLoader individualService;
    private final ObjectMapper objectMapper;
    private final StringBuilder nullFields;
    private final StringBuilder comments;
    private final RestTemplate restTemplate;
    private final KafkaTemplate<String, IndividualDto> kafkaTemplate;
    private final NewTopic topic;
    private static final String CP_SERVICE = "http://localhost:8080/individual/get/?icp=";
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessage(ConsumerRecord<String, AddressDto> record) {
        LOGGER.info(String.format("Object %s received", record.value()));
    }

    @SneakyThrows
    @KafkaListener(topics = "${spring.kafka.topic.name1}", groupId = "${spring.kafka.consumer.group-id}")
    public void ListeningTopicRecognitionDocument(ConsumerRecord<String, DocumentDto> message, String icp) {
        // По ключу ICP ищем клиента
        if (individualService.findByIcp(icp) != null) {
            IndividualDto individualDto = restTemplate.getForEntity(CP_SERVICE + icp, IndividualDto.class).getBody();
            if (individualDto != null) {
                // Если нашел:
                try {
                    DocumentDto dto = objectMapper.readValue(message.value().toString(), DocumentDto.class);
                    // В IndividualDto -> DocumentDto --- Сохранить полученный документ из kafka
                    individualDto.setDocuments((Collection<DocumentDto>) dto);
                    // В поле ErrorDto записать какие поля не распознаны и в коментарии указать сообщение, требуется работа оператора
                    RFPassport passport = dto.getDocumentDto().get("RFPassportDoc");
                    try {

                        Field[] fields = RFPassport.class.getDeclaredFields();
                        nullFields.append("Null Fields: ");
                        comments.append("Requires operator work with fields");

                        for (Field field : fields) {
                            field.setAccessible(true);
                            if (field.get(passport) != null) {
                                // В IndividualDto -> ErrorDto    --- Оставить комментарий, что нужно проверить поля
                                comments.append(field.getName()).append(", ");
                            } else {
                                // В IndividualDto -> ErrorDto    --- Записать названия полей с null
                                nullFields.append(field.getName()).append(", ");
                            }
                        }
                        // Удалили последние ", "
                        comments.delete(comments.length() - 2, comments.length() - 1).append(".");
                        nullFields.delete(comments.length() - 2, comments.length() - 1).append(".");

                        //individualDto.setErrors((Collection<ErrorDto>) new ErrorDto(comments.toString(), nullFields.toString()));

                        comments.delete(0, comments.length());
                        nullFields.delete(0, nullFields.length());

                        // Отправляем в кафку дополненный individualDto
                        kafkaTemplate.send(topic.name(),individualDto);
                    } catch (IllegalAccessException e) {
                        throw e;
                    }
                } catch (JsonProcessingException | ClassCastException | IllegalAccessException e) {
                    throw e;
                }
            }
        }
    }
}
