package org.client.ClientProfileService.service;

import org.client.ClientProfileService.dto.IndividualDto;
//import org.client.dto.IndividualDto;

public interface IndividualService {

    void addClient(IndividualDto dto);

    IndividualDto getClient(String icp);

    IndividualDto getClientByPhoneNumber(String phoneNumber);

}
