package org.client.ClientProfileService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "Модель свидетельства о разводе")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DivorceCertDoc {

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

    @JsonProperty(Fields.message)
    private String message;

    @JsonProperty(Fields.actData)
    private String actData;

    @JsonProperty(Fields.issued)
    private String issued;

    @JsonProperty(Fields.name)
    private String name;

    @JsonProperty(Fields.actNo)
    private String actNo;

    @JsonProperty(Fields.patronymic)
    private String patronymic;

    @JsonProperty(Fields.surname)
    private String surname;

    @JsonProperty(Fields.gender)
    private String gender;

    @JsonProperty(Fields.birthdate)
    private String birthdate;

    @JsonProperty(Fields.legalForce)
    private String legalForce;


    public static class Fields {
        public static final String series = "departmentDoc";
        public static final String number = "receiptDocDate";
        private static final String issued = "issued";
        public static final String departmentDoc = "departmentDoc";
        public static final String receiptDocDate = "receiptDocDate";
        private static final String validateDateDoc = "validateDateDoc";
        private static final String actNo = "actNo";
        private static final String actData = "actData";
        private static final String issued_by= "issued_by";
        private static final String name = "name";
        public static final String patronymic = "patronymic";
        private static final String surname = "surname";
        private static final String gender = "gender";
        private static final String birthdate = "birthdate";
        private static final String message = "message";
        private static final String legalForce = "legalforce";
    }

}
