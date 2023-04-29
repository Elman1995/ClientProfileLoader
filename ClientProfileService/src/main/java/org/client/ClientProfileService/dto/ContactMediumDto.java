package org.client.ClientProfileService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.client.ClientProfileService.entity.Contacts.Email;
import org.client.ClientProfileService.entity.Contacts.PhoneNumber;
import org.client.ClientProfileService.entity.Individual;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ContactMediumDto {

    @JsonProperty(Fields.UUID)
    private String uuid;

    @JsonProperty(Fields.INDIVIDUAL)
    private Individual individual;

    @JsonProperty(Fields.EMAILS)
    private Collection<Email> emails;

    @JsonProperty(Fields.PHONE_NUMBERS)
    private Collection<PhoneNumber> phoneNumbers;

    public static class Fields {

        private static final String UUID = "uuid";

        private static final String INDIVIDUAL = "individual";

        private static final String EMAILS = "emails";

        private static final String PHONE_NUMBERS = "phoneNumbers";
    }
}
