package dev.alfrendosilalahi.eazybank.account.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        name = "Update Account",
        description = "Update account information"
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAccountRequestDto {

    @Schema(
            description = "Name of the customer",
            example = "Jane Doe"
    )
    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @Schema(
            description = "Email address of the customer",
            example = "jane.doe@email.com"
    )
    @NotEmpty(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Schema(
            description = "Mobile number of the customer",
            example = "1234567890"
    )
    @NotEmpty(message = "Mobile number can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must use number char and must have 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account number of the customer",
            example = "1234567890"
    )
    @NotEmpty(message = "Account number can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must use number char and must have 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account type of the customer",
            example = "Savings"
    )
    @NotEmpty(message = "Account type can not be a null or empty")
    private String accountType;

    @Schema(
            description = "Account branch address of the customer",
            example = "123 Main Street"
    )
    @NotEmpty(message = "Account branch address can not be a null or empty")
    private String accountBranchAddress;

}
