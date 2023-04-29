package org.client.ClientProfileService.util;

import org.client.ClientProfileService.dto.AddressDto;
import org.client.ClientProfileService.dto.IndividualDto;
import org.client.ClientProfileService.dto.WalletDto;
import org.client.ClientProfileService.entity.Address;
import org.client.ClientProfileService.entity.Individual;
import org.client.ClientProfileService.entity.Wallet;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MappingUtils {

    public IndividualDto mapToIndividualDto(Individual individualEntity) {
        if (individualEntity == null) {
            return null;
        }

        IndividualDto individualDto = new IndividualDto();
        individualDto.setIcp(String.valueOf(individualEntity.getIcp()));
        individualDto.setUuid(individualEntity.getUuid());
        individualDto.setName(individualEntity.getName());
        individualDto.setSurname(individualEntity.getSurname());
        individualDto.setPatronymic(individualEntity.getPatronymic());
        individualDto.setFullName(individualEntity.getFullname());
        individualDto.setGender(individualEntity.getGender());
        individualDto.setPlaceOfBirth(individualEntity.getPlaceofbirth());
        individualDto.setCountryOfBirth(individualEntity.getCountryofbirth());
        individualDto.setBirthDate(individualEntity.getBirthdate());

        if (individualEntity.getWallets() != null) {
            WalletDto walletDto = mapToWalletDto(individualEntity.getWallets());
            individualDto.setWallet(Collections.singleton(walletDto));
        } else {
            individualDto.setWallet(null);
        }

        if (individualEntity.getAddresses() != null) {
            AddressDto addressDto = mapToAddressDto(individualEntity.getAddresses());
            individualDto.setAddress(Collections.singleton(addressDto));
        } else {
            individualDto.setAddress(null);
        }

        return individualDto;
    }

    public WalletDto mapToWalletDto(Wallet wallet) {
        if (wallet == null) {
            return null;
        }

        WalletDto walletDto = new WalletDto();
        walletDto.setUuid(wallet.getUuid());
        walletDto.setRubWallet(wallet.getRubWallet());
        walletDto.setDollarWallet(wallet.getDollarWallet());
        walletDto.setEuroWallet(wallet.getEuroWallet());

        return walletDto;
    }

    public AddressDto mapToAddressDto(Address address) {
        if (address == null) {
            return null;
        }

        AddressDto addressDto = new AddressDto();
        addressDto.setUuid(address.getUuid());
        addressDto.setNotFormAddrName(address.getNotFormAddrName());
        addressDto.setAddressName(address.getAddressName());
        addressDto.setCountry(address.getCountry());
        addressDto.setZipCode(address.getZipCode());

        return addressDto;
    }

}
