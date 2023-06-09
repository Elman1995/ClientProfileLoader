package org.client.ClientProfileLoader.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.client.ClientProfileLoader.entity.Contacts.Email;
import org.client.ClientProfileLoader.entity.Contacts.PhoneNumber;
import javax.persistence.*;
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
