package org.client.ClientProfileLoader.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.client.ClientProfileLoader.dto.AddressDto;
import org.client.ClientProfileLoader.dto.DocumentDto;

public interface ListnersTopics {
    void consumeMessage(ConsumerRecord<String, AddressDto> record);
    void ListeningTopicRecognitionDocument(ConsumerRecord<String, DocumentDto> message, String icp) throws JsonProcessingException, IllegalAccessException;
}
