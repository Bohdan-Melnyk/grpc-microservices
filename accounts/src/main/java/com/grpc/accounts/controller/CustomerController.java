package com.grpc.accounts.controller;

import com.grpc.accounts.dto.CustomerDetailsDto;
import com.grpc.accounts.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "REST API for customers in the bank",
        description = "REST APIs in bank to fetch customer details"
)
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class CustomerController {

    private final CustomerService customerService;

    @Operation(
            summary = "Fetch customer details",
            description = "" +
                    "Fetch customer details based on mobile number"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(@RequestParam
                                                                   @Pattern(regexp = "(^$|[0-9]{10})",
                                                                           message = "Mobile number must be 10 digits")
                                                                           String mobileNumber) {
        var customerDetailsDto = customerService.fetchCustomerDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDetailsDto);
    }

    @Operation(
            summary = "Fetch customer details using gRPC protocol",
            description = "" +
                    "Fetch customer details based on mobile number"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("/fetchCustomerDetailsProto")
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetailsProto(@RequestParam
                                                                       /* @Pattern(regexp = "(^$|[0-9]{10})",
                                                                                message = "Mobile number must be 10 digits")*/
                                                                                String mobileNumber) {
        var customerDetailsDto = customerService.fetchCustomerDetailsProto(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDetailsDto);
    }
}
