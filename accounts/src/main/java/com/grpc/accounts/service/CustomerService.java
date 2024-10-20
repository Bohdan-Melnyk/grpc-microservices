package com.grpc.accounts.service;

import com.grpc.accounts.dto.CustomerDetailsDto;

public interface CustomerService {

    /**
     *
     * @param mobileNumber - mobile number
     * @return Customer details
     */
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);

    CustomerDetailsDto fetchCustomerDetailsProto(String mobileNumber);
}
