package org.client.ClientProfileService.entity.Contacts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.client.ClientProfileService.entity.ContactMedium;
import javax.persistence.*;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String uuid;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="phoneNumbers")
    private ContactMedium contactMedium;

    @Column(name = "phoneNumberValue")
    private String value;

    @Column(name = "isActive")
    private boolean isActive;
}
