package org.client.ClientProfileService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import org.client.ClientProfileService.entity.Contacts.Email;
import org.client.ClientProfileService.entity.Contacts.PhoneNumber;

import java.util.Collection;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactMedium {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String uuid;

    @OneToOne(mappedBy = "contacts", cascade = CascadeType.ALL)
    private Individual individual;

    @OneToMany(mappedBy = "contactMedium")
    private Collection<Email> emails;

    @OneToMany(mappedBy = "contactMedium")
    private Collection<PhoneNumber> phoneNumbers;

}
