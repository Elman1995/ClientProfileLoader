package org.client.ClientProfileService.service;

import org.client.ClientProfileService.dto.AddressDto;
//import org.client.dto.AddressDto;

public interface AddressService {

    void addAddressForClient(String icp, String address);

    AddressDto getAddressClient(String icp);

}
