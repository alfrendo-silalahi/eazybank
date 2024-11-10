package dev.alfrendosilalahi.eazybank.account.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(
    name = "Error Base Response",
    description = "Error base response information"
)
@Data
@Builder
public class ErrorBaseResponseDto {

    @Schema(
            description = "API path",
            example = "/api/v1/account"
    )
    private String apiPath;

    @Schema(
            description = "Error code",
            example = "400"
    )
    private int code;

    @Schema(
            description = "Error message",
            example = "Bad Request"
    )
    private String message;

    @Schema(
            description = "Error time",
            example = "2022-01-01 00:00:00"
    )
    private LocalDateTime time;

}
