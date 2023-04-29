package org.client.ClientProfileService.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
@Schema(description = "Модель документа СНИЛС")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SNILSDoc {

    @JsonProperty(Fields.receiptDocDate)
    private String receiptDocDate;

    @JsonProperty(Fields.validateDateDoc)
    private String validateDateDoc;

    @JsonProperty(Fields.snils)
    private String snils;

    @JsonProperty(Fields.issued)
    private String  issued;

    @JsonProperty(Fields.name)
    private String name;

    @JsonProperty(Fields.patronymic)
    private String patronymic;

    @JsonProperty(Fields.surname)
    private String surname;

    @JsonProperty(Fields.gender)
    private String gender;

    @JsonProperty(Fields.birthdate)
    private String birthdate;

    @JsonProperty(Fields.birthplace)
    private String birthplace;


    public static class Fields {
        public static final String receiptDocDate = "receiptDocDate";
        private static final String validateDateDoc = "validateDateDoc";
        private static final String snils = "snils";
        private static final String issued = "issued";
        private static final String name = "name";
        public static final String patronymic = "patronymic";
        private static final String surname = "surname";
        private static final String gender = "gender";
        private static final String birthdate = "birthdate";
        private static final String birthplace = "birthplace";

    }
}



