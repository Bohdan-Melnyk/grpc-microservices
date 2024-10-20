package com.grpc.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(
        name = "Accounts",
        description = "Schema to hold accounts information"
)
public class AccountsDto {

    @NotEmpty(message = "name can`t be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    @Schema(
            description = "mobile number"
    )
    private Long accountNumber;

    @NotEmpty(message = "accountType can`t be empty")
    @Schema(
            description = "Account type",
            example = "Savings"
    )
    private String accountType;

    @NotEmpty(message = "branchAddress can`t be empty")
    @Schema(
            description = "Branch address",
            example = "123 New York"
    )
    private String branchAddress;
}
