package dev.alfrendosilalahi.leafbank.ms__account.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(
        name = "Account Response",
        description = "Account response information"
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountResponseDto {

    @Schema(
            description = "Account information"
    )
    private AccountResponse account;

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class AccountResponse {

        @Schema(
                description = "Name of the customer",
                example = "Jane Doe"
        )
        private String name;

        @Schema(
                description = "Email address of the customer",
                example = "jane.doe@email.com"
        )
        private String email;

        @Schema(
                description = "Mobile number of the customer",
                example = "1234567890"
        )
        private String mobileNumber;

        @Schema(
                description = "Account number of the customer",
                example = "1234567890"
        )
        private Long number;

        @Schema(
                description = "Account type of the customer",
                example = "Savings"
        )
        private String type;

        @Schema(
                description = "Branch address of the customer",
                example = "123 Main St, Anytown, USA"
        )
        private String branchAddress;

    }

}
