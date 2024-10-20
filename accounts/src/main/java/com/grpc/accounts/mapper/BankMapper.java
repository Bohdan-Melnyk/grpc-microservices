package com.grpc.accounts.mapper;

import com.bank.Bank;
import com.grpc.accounts.dto.CardsDto;
import com.grpc.accounts.dto.LoansDto;

public class BankMapper {

    public static CardsDto mapToCardsDto(Bank.CardsDto bankCardsDto) {
        CardsDto cardsDto = new CardsDto();
        cardsDto.setMobileNumber(bankCardsDto.getMobileNumber());
        cardsDto.setCardNumber(bankCardsDto.getCardNumber());
        cardsDto.setCardType(bankCardsDto.getCardType());
        cardsDto.setAmountUsed(bankCardsDto.getAmountUsed());
        cardsDto.setAvailableAmount(bankCardsDto.getAvailableAmount());
        cardsDto.setTotalLimit(bankCardsDto.getTotalLimit());
        return cardsDto;
    }

    public static LoansDto mapToLoansDto(Bank.LoanDto bankLoansDto) {
        LoansDto loansDto = new LoansDto();
        loansDto.setMobileNumber(bankLoansDto.getMobileNumber());
        loansDto.setLoanNumber(bankLoansDto.getLoanNumber());
        loansDto.setLoanType(bankLoansDto.getLoanType());
        loansDto.setAmountPaid(bankLoansDto.getAmountPaid());
        loansDto.setTotalLoan(bankLoansDto.getTotalLoan());
        loansDto.setOutstandingAmount(bankLoansDto.getOutstandingAmount());
        return loansDto;
    }
}
