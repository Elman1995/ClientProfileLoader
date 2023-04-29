package org.client.ClientProfileService.masking;

import org.client.ClientProfileService.dto.AddressDto;
//import org.client.dto.AddressDto;

public interface AddressServiceMasking {

    void addAddressForClient(String icp, String address);

    AddressDto getAddressClient(String icp);

}
