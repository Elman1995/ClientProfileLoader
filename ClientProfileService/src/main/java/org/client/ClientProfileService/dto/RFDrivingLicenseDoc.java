package org.client.ClientProfileService.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "Модель водительского удостоверения")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RFDrivingLicenseDoc {
    @JsonProperty(Fields.departmentDoc)
    private String departmentDoc;

    @JsonProperty(Fields.issuedBy)
    private String issuedBy;

    @JsonProperty(Fields.receiptDocDate)
    private String receiptDocDate;

    @JsonProperty(Fields.validateDateDoc)
    private String validateDateDoc;

    @JsonProperty(Fields.series)
    private String series;

    @JsonProperty(Fields.message)
    private String message;

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

    @JsonProperty(Fields.countryName)
    private String countryName;

    @JsonProperty(Fields.birthdate)
    private String birthdate;

    @JsonProperty(Fields.categories)
    private String categories;
    @JsonProperty(Fields.experience)
    private String experience;

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
        private static final String birthdate = "birthdate";
        private static final String birthplace = "birthplace";
        private static final String countryName = "countryName";
        private static final String issuedBy = "issuedBy";
        private static final String expireDate = "expireDate";
        private static final String categories = "categories";
        private static final String experience = "experience";
        private static final String message = "message";
        private static final String legalForce = "legalforce";
    }
}

