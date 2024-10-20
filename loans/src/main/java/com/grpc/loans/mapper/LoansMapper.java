package com.grpc.loans.mapper;

import com.bank.Bank;
import com.grpc.loans.dto.LoansDto;
import com.grpc.loans.entity.Loans;

public class LoansMapper {
    public static LoansDto mapToLoansDto(Loans loans, LoansDto loansDto) {
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setLoanType(loans.getLoanType());
        loansDto.setMobileNumber(loans.getMobileNumber());
        loansDto.setTotalLoan(loans.getTotalLoan());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setOutstandingAmount(loans.getOutstandingAmount());
        return loansDto;
    }

    public static Loans mapToLoans(LoansDto loansDto, Loans loans) {
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setLoanType(loansDto.getLoanType());
        loans.setMobileNumber(loansDto.getMobileNumber());
        loans.setTotalLoan(loansDto.getTotalLoan());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutstandingAmount(loansDto.getOutstandingAmount());
        return loans;
    }

    public static Bank.LoanDto mapToLoansDtoProto(Loans loans) {
        return Bank.LoanDto.newBuilder()
                .setLoanNumber(loans.getLoanNumber())
                .setLoanType(loans.getLoanType())
                .setMobileNumber(loans.getMobileNumber())
                .setTotalLoan(loans.getTotalLoan())
                .setAmountPaid(loans.getAmountPaid())
                .setOutstandingAmount(loans.getOutstandingAmount())
                .build();
    }
}
