package org.client.ClientProfileService.masking;

import org.client.ClientProfileService.dto.IndividualDto;
//import org.client.dto.IndividualDto;

public interface IndividualServiceMasking {

    void addClient(String icp, String name);

    IndividualDto getClient(String icp);

}
