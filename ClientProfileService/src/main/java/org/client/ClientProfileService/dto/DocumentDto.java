package org.client.ClientProfileService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.client.ClientProfileService.entity.RFPassport;

import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDto implements Serializable {
    Map<String, RFPassport> documentDto;
}
