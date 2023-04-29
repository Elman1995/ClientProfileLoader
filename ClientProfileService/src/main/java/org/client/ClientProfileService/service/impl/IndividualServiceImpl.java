package org.client.ClientProfileService.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.client.ClientProfileService.dto.IndividualDto;
import org.client.ClientProfileService.repositories.IndividualRepository;
import org.client.ClientProfileService.service.IndividualService;
import org.client.ClientProfileService.util.MappingUtils;
import org.client.ClientProfileService.util.RequestClientProfileLoaderException;
import org.client.ClientProfileService.util.exceptions.EmptyParameterException;
import org.client.ClientProfileService.util.exceptions.NotFoundClientException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional(readOnly = true)
@Slf4j
@AllArgsConstructor
public class IndividualServiceImpl implements IndividualService {
    private final RestTemplate restTemplate;
    private static final String addressCPLoader = "http://localhost:8080/api/clients";
    private final IndividualRepository individualRepository;
    private final MappingUtils mappingUtils;

    @Override
    public void addClient(IndividualDto dto) {
        ResponseEntity<?> responseEntity = restTemplate.exchange(addressCPLoader, HttpMethod.POST,
                new HttpEntity<IndividualDto>(dto), IndividualDto.class);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            log.error("Subrequest on MKS ProfileLoader failed");
            throw new RequestClientProfileLoaderException("An error occurred while creating the client");
        }
    }

    @Override
    public IndividualDto getClient(String icp) {
        if (icp == null) {
            throw new EmptyParameterException("Parameter icp not set");
        }

        ResponseEntity<IndividualDto> responseEntity = restTemplate.getForEntity(addressCPLoader + "?icp=" + icp,
                IndividualDto.class);
        IndividualDto individualDtoFromDB = null;
        try {
            individualDtoFromDB = responseEntity.getBody();
        } catch (NullPointerException e) {
            log.warn(String.format("Individual with ICP %s  not found", icp));
            throw new NotFoundClientException("Not found client with icp = " + icp + " in database");
        }
        return individualDtoFromDB;
    }

    @Override
    public IndividualDto getClientByPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            throw new EmptyParameterException("Parameter phone number not set");
        }
        IndividualDto individualDto = mappingUtils.mapToIndividualDto(individualRepository.findByContacts(phoneNumber));
        if (individualDto == null) {
            log.warn(String.format("Individual with phone number %s not found", phoneNumber));
            throw new NotFoundClientException("Not found client with phone number = " + phoneNumber + " in database");
        }

        return individualDto;
    }
}
