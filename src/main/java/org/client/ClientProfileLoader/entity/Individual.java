package org.client.ClientProfileLoader.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Schema(description = "Модель, описывающая пользоватяле в ЛК банка")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "individual")
public class Individual implements Serializable {

    @Schema(example = "1000000", description = "Идентификатор Клиентского профиля")
    @JsonProperty(Fields.ICP)
    @Column(name = "icp")
    @Size(min = 7, max = 100)
    private String icp;

    @Schema(example = "4800c301-50a5-46f9-8c5f-6d6b3fbc55nf", description = "Идентификатор клиента по стандарту RFC4122")
    @JsonProperty(Fields.UUID)
    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "gender")
    private String gender;

    @Column(name = "placeofbirth")
    private String placeofbirth;

    @Column(name = "countryofbirth")
    private String countryofbirth;

    @Column(name = "birthdate")
    private Date birthdate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallets")
    private Wallet wallets;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addresses")
    private Address addresses;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "documents")
    private Documents documents;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rfPassport")
    private RFPassport rfPassport;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contacts")
    private ContactMedium contacts;

    public static class Fields {
        public static final String UUID = "uuid";

        public static final String ICP = "icp";
    }
}
