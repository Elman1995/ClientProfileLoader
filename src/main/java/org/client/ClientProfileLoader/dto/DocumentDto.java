package org.client.ClientProfileLoader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.client.ClientProfileLoader.entity.RFPassport;
import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDto implements Serializable {
    Map<String, RFPassport> documentDto;
}
