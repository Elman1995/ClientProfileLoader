package org.client.ClientProfileLoader.service;

import org.client.ClientProfileLoader.dto.ContactUpdateDto;
import org.client.ClientProfileLoader.entity.Individual;
import org.client.ClientProfileLoader.entity.RFPassport;

public interface IndividualServiceLoader {

    Individual findByIcp(String icp);

    void saveIndividual(Individual individual);

    void saveRFPassport(RFPassport rfPassport, String icp);

    void updateEmail(ContactUpdateDto contactUpdateDto);

    void updatePhoneNumber(ContactUpdateDto contactUpdateDto);

}
