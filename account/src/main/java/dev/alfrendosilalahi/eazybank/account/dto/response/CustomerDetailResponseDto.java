package dev.alfrendosilalahi.eazybank.account.dto.response;

import dev.alfrendosilalahi.eazybank.account.dto.client.card.CardsDto;
import dev.alfrendosilalahi.eazybank.account.dto.client.loan.LoansDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Schema(
        name = "Customer Detail",
        description = "Customer detail includes account, card, and loan information."
)
@Builder
public class CustomerDetailResponseDto {

    @Schema(
            description = "Account information"
    )
    private AccountResponse account;

    private LoansDto loansDto;

    private CardsDto cardsDto;

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
