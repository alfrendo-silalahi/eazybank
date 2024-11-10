package dev.alfrendosilalahi.eazybank.account.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Schema(
    name = "Success Base Response",
    description = "Success base response information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessBaseResponseDto<T> {

    @Schema(
            description = "API path",
            example = "/api/v1/account"
    )
    private String apiPath;

    @Schema(
            description = "Success code",
            example = "200"
    )
    private int code;

    @Schema(
            description = "Status of the request",
            example = "OK"
    )
    private String status;

    @Schema(
            description = "Data of the request",
            example = "{}"
    )
    private T data;

    public static <T> ResponseEntity<SuccessBaseResponseDto<T>> createSuccessBaseResponseDto(
            HttpStatus httpStatus,
            int code,
            String status
    ) {
        return ResponseEntity
                .status(httpStatus)
                .body(SuccessBaseResponseDto.<T>builder()
                        .code(code)
                        .status(status)
                        .build()
                );
    }

    public static <T> ResponseEntity<SuccessBaseResponseDto<T>> createSuccessBaseResponseDto(
            HttpStatus httpStatus,
            int code,
            String status,
            T data
    ) {
        return ResponseEntity
                .status(httpStatus)
                .body(SuccessBaseResponseDto.<T>builder()
                        .code(code)
                        .data(data)
                        .status(status)
                        .build()
                );

    }

}
