package org.client.ClientProfileService.masking.impl;

import lombok.AllArgsConstructor;
import org.client.ClientProfileService.dto.AddressDto;
import org.client.ClientProfileService.dto.IndividualDto;
import org.client.ClientProfileService.masking.AddressServiceMasking;
import org.client.ClientProfileService.masking.IndividualServiceMasking;

import java.util.Collections;

@AllArgsConstructor
public class AddressServiceMaskingImpl implements AddressServiceMasking {

    private final IndividualServiceMasking individualService;

    @Override
    public void addAddressForClient(String icp, String address) {
        try {
            IndividualDto dto = individualService.getClient(icp);
            AddressDto addressDto = AddressDto.builder().addressName(address).build();
            dto.setAddress(Collections.singleton(addressDto));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public AddressDto getAddressClient(String icp) {
        return (AddressDto) Collections.singleton(individualService.getClient(icp).getAddress());
    }
}
