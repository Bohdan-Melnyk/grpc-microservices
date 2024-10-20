package com.grpc.accounts.service.grpc;

import com.bank.Bank;

public interface BankServiceProto {

    Bank.CardsDto getCardsInfo(String cardNumber);

    Bank.LoanDto getLoansInfo(String cardNumber);
}
