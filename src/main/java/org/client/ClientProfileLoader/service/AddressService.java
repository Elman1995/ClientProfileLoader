package org.client.ClientProfileLoader.service;

import org.client.ClientProfileLoader.dto.AddressDto;

public interface AddressService {

    void addAddressForClient(String icp, String address);

    AddressDto getAddressClient(String icp);

}
