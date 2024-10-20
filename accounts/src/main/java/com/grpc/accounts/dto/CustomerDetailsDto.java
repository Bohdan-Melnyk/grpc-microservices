package com.grpc.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(
        name = "CustomerDetails",
        description = "Schema to hold customer, account, cards and loans information"
)
public class CustomerDetailsDto {

    @NotEmpty(message = "name can`t be empty")
    @Schema(
            description = "Name of the customer",
            example = "John Doe"
    )
    private String name;

    @NotEmpty(message = "Email can`t be empty")
    @Schema(
            description = "Customer`s email",
            example = "john.doe@example.com"
    )
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    @Schema(
            name = "mobile number",
            description = "Customer`s mobile number",
            example = "4645978134"
    )
    private String mobileNumber;

    @Schema(
            description = "Customer`s account details"
    )
    AccountsDto accountsDto;

    @Schema(
            description = "Cards details of the customer"
    )
    CardsDto cardsDto;

    @Schema(
            description = "Loans details of the customer"
    )
    LoansDto loansDto;
}
