package org.client.ClientProfileLoader.service.impl;

import com.github.sonus21.rqueue.annotation.RqueueListener;
import lombok.AllArgsConstructor;
import org.client.ClientProfileLoader.dto.ContactUpdateDto;
import org.client.ClientProfileLoader.entity.Contacts.Email;
import org.client.ClientProfileLoader.entity.Contacts.PhoneNumber;
import org.client.ClientProfileLoader.entity.Individual;
import org.client.ClientProfileLoader.entity.RFPassport;
import org.client.ClientProfileLoader.repositories.IndividualRepository;
import org.client.ClientProfileLoader.service.IndividualServiceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class IndividualServiceLoaderImpl implements IndividualServiceLoader {

    private IndividualRepository individualRepository;

    @Override
    public Individual findByIcp(String icp) {
        return individualRepository.findByIcp(icp);
    }

    @Override
    @Transactional
    public void saveIndividual(Individual individual) {
        individualRepository.save(individual);
    }
    @Transactional
    @Override
    public void saveRFPassport(RFPassport rfPassport, String icp) {
        Individual individual = findByIcp(icp);
        individual.setRfPassport(rfPassport);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    @RqueueListener(value = "${email.queue.name}")
    public void updateEmail(ContactUpdateDto contactUpdateDto) {
        Individual individual = findByIcp(contactUpdateDto.getIcp());
        Email email = Email.builder()
                .uuid(UUID.randomUUID().toString())
                .value(contactUpdateDto.getContact())
                .isActive(true)
                .build();
        List<Email> emails = new ArrayList<>(individual.getContacts().getEmails());
        emails.add(email);
        individual.getContacts().setEmails(emails);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    @RqueueListener(value = "${phoneNumber.queue.name}")
    public void updatePhoneNumber(ContactUpdateDto contactUpdateDto) {
        Individual individual = findByIcp(contactUpdateDto.getIcp());
        PhoneNumber phoneNumber = PhoneNumber.builder()
                .uuid(UUID.randomUUID().toString())
                .value(contactUpdateDto.getContact())
                .isActive(true)
                .build();
        List<PhoneNumber> phoneNumbers = new ArrayList<>(individual.getContacts().getPhoneNumbers());
        phoneNumbers.add(phoneNumber);
        individual.getContacts().setPhoneNumbers(phoneNumbers);
    }
}

