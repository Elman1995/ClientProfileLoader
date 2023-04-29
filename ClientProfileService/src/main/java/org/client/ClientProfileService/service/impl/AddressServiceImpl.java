package org.client.ClientProfileService.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.client.ClientProfileService.dto.AddressDto;
import org.client.ClientProfileService.entity.Address;
import org.client.ClientProfileService.entity.Individual;
import org.client.ClientProfileService.repositories.IndividualRepository;
import org.client.ClientProfileService.service.AddressService;
import org.client.ClientProfileService.service.IndividualService;
import org.client.ClientProfileService.util.MappingUtils;
import org.client.ClientProfileService.util.exceptions.AddressWithSuchICPExists;
import org.client.ClientProfileService.util.exceptions.EmptyParameterException;
import org.client.ClientProfileService.util.exceptions.NotFoundAddressException;
import org.client.ClientProfileService.util.exceptions.NotFoundClientException;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@AllArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class AddressServiceImpl implements AddressService {

    private final IndividualService individualService;
    private final IndividualRepository individualRepository;
    private final MappingUtils mappingUtils;

    @Override
    @Transactional
    public void addAddressForClient(String icp, String address) {
        if (address == null) {
            throw new EmptyParameterException("Parameter 'Address name' not set");
        }

        if (icp == null) {
            throw new EmptyParameterException("Parameter 'icp' not set");
        } else {
            Individual individual = individualRepository.findByIcp(icp);
            if (individual == null) {
                throw new NotFoundClientException("Not found client with icp = " + icp +
                        " in database to add an address");
            }

            Address addressEntity = individual.getAddresses();
            if(addressEntity != null) {
                log.warn("During adding an address for client occur an exception");
                throw new AddressWithSuchICPExists("Address with such icp = " + icp + " exists");
            }

            Address addressEntityNew = new Address();
            addressEntityNew.setIcp(icp);
            addressEntityNew.setUuid(UUID.randomUUID().toString());
            addressEntityNew.setAddressName(address);
            individual.setAddresses(addressEntityNew);
            individualRepository.save(individual);
        }
    }

    @Override
    public AddressDto getAddressClient(String icp) {
        log.info("Getting address of individual by ICP");
        Individual individual = individualRepository.findByIcp(icp);
        if (individual == null) {
            log.warn(String.format("Individual with ICP %s  not found", icp));
            throw new NotFoundClientException("Not found client with icp = " + icp + " in database to get an address");
        }

        AddressDto addressDto = mappingUtils.mapToAddressDto(individual.getAddresses());
        if (addressDto == null) {
            throw new NotFoundAddressException("Not found address with icp = " + icp + " in database");
        }

        return addressDto;
    }
}
