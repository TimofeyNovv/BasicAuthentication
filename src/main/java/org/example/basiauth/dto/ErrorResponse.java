package org.example.basiauth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    @Schema(description = "краткое описание ошибки")
    private String responseCode;

    @Schema(description = "подробное описание ошибки")
    private String description;

    @Schema(description = "время в которое появилась ошибка")
    private LocalDateTime time;

}
