package com.grpc.loans.service;

import com.grpc.loans.dto.LoansDto;

public interface LoansService {

    /**
     *
     * @param mobileNumber
     */
    void createLoan(String mobileNumber);

    /**
     *
     * @param mobileNumber
     * @return
     */
    LoansDto fetchLoan(String mobileNumber);

    /**
     *
     * @param loansDto
     * @return
     */
    boolean updateLoan(LoansDto loansDto);

    /**
     *
     * @param mobileNumber
     * @return
     */
    boolean deleteLoan(String mobileNumber);
}
