package org.client.ClientProfileService.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MoneyTransferDto {
    private String event;

    private String phoneNumber;

    private String payment;
}
