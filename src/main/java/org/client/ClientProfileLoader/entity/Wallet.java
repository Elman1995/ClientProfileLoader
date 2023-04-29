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

@Schema(description = "Модель, описывающая баланс пользоватяле в ЛК банка")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "wallet")
public class Wallet implements Serializable {

    @Schema(example = "1000000", description = "Идентификатор кошелька")
    @JsonProperty(Fields.ICP)
    @Column(name = "icp")
    @Size(min = 7, max = 100)
    private String icp;

    @Schema(example = "4800c301-50a5-46f9-8c5f-6d6b3fbc55nf", description = "Идентификатор кошелька по стандарту RFC4122")
    @JsonProperty(Fields.UUID)
    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "rubwallet")
    @JsonProperty(Fields.RUB_WALLET)
    private String rubWallet;

    @Column(name = "eurowallet")
    private String euroWallet;

    @Column(name = "dollarwallet")
    private String dollarWallet;

    @OneToOne(mappedBy = "wallets", cascade = CascadeType.ALL)
    private Individual individual;

    public static class Fields {
        public static final String UUID = "uuid";
        public static final String ICP = "icp";
        public static final String RUB_WALLET = "rubWallet";
    }

}
