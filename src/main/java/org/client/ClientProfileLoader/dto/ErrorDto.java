package org.client.ClientProfileLoader.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "Модель, описывающая какие поля в документе с ошибками или пустые")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorDto {
    @Schema(example = "Requires operator work with fields:...", description = "Комментарии к полям, в которых требуется работа оператора")
    private String comments;
    @Schema(example = "Null Fields:...", description = "Поля, которые не удалось распознать")
    private String nullFields;
}
