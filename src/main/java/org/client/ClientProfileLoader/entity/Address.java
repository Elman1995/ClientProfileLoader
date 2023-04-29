package org.client.ClientProfileLoader.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Schema(description = "Модель, описывающая адрес")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Schema(example = "1000000", description = "Идентификатор адреса")
    @JsonProperty(Wallet.Fields.ICP)
    @Column(name = "icp")
    @Size(min = 7, max = 100)
    private String icp;

    @Schema(example = "4800c301-50a5-46f9-8c5f-6d6b3fbc55nf", description = "Идентификатор адреса по стандарту RFC4122")
    @JsonProperty(Fields.UUID)
    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "notformaddrname")
    private String notFormAddrName;

    @Column(name = "addressname")
    private String addressName;

    @Column(name = "country")
    private String country;

    @Column(name = "zipcode")
    private String zipCode;

    @OneToOne(mappedBy = "addresses", cascade = CascadeType.ALL)
    private Individual individual;

    public static class Fields {
        public static final String UUID = "uuid";
    }
}
