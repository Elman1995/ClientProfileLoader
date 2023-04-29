package org.client.ClientProfileService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "Модель документа загран. паспорта")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FRGNPassportDoc {
    @JsonProperty(Fields.departmentDoc)
    private String departmentDoc;

    @JsonProperty(Fields.issued_by)
    private String issued_by;

    @JsonProperty(Fields.receiptDocDate)
    private String receiptDocDate;

    @JsonProperty(Fields.validateDateDoc)
    private String validateDateDoc;

    @JsonProperty(Fields.series)
    private String series;

    @JsonProperty(Fields.latinName)
    private String latinName;

    @JsonProperty(Fields.latinSurname)
    private String latinSurname;

    @JsonProperty(Fields.invalidityReason)
    private String invalidityReason;

    @JsonProperty(Fields.message)
    private String message;

    @JsonProperty(Fields.passportStatus)
    private String passportStatus;

    @JsonProperty(Fields.legalForce)
    private String legalForce;

    @JsonProperty(Fields.issued)
    private String issued;

    @JsonProperty(Fields.name)
    private String name;

    @JsonProperty(Fields.expireDate)
    private String expireDate;

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
        public static final String series = "departmentDoc";
        public static final String number = "receiptDocDate";
        private static final String issued = "issued";
        public static final String departmentDoc = "departmentDoc";
        public static final String receiptDocDate = "receiptDocDate";
        private static final String validateDateDoc = "validateDateDoc";
        private static final String name = "name";
        public static final String patronymic = "patronymic";
        private static final String surname = "surname";
        private static final String gender = "gender";
        private static final String birthdate = "birthdate";
        private static final String birthplace = "birthplace";
        private static final String issued_by= "issued_by";
        private static final String latinName = "latinName";
        private static final String latinSurname = "LatinSurname";
        private static final String expireDate = "expireDate";
        private static final String invalidityReason = "invalidityReason";
        private static final String message = "message";
        private static final String  passportStatus = "passportStatus";
        private static final String legalForce = "legalforce";
    }


}
