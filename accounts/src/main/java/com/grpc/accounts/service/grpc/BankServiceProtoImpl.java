package com.grpc.accounts.service.grpc;

import com.bank.Bank;
import com.bank.CardsServiceGrpc;
import com.bank.LoansServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class BankServiceProtoImpl implements BankServiceProto {

    @GrpcClient("cards")
    CardsServiceGrpc.CardsServiceBlockingStub cardsServiceBlockingStub;

    @GrpcClient("loans")
    LoansServiceGrpc.LoansServiceBlockingStub loansServiceBlockingStub;

    @Override
    public Bank.CardsDto getCardsInfo(String cardNumber) {
        Bank.StringValue stringValue = Bank.StringValue.newBuilder().setValue(cardNumber).build();
        return cardsServiceBlockingStub.fetchCardDetailsProto(stringValue);
    }

    @Override
    public Bank.LoanDto getLoansInfo(String cardNumber) {
        Bank.StringValue stringValue = Bank.StringValue.newBuilder().setValue(cardNumber).build();
        return loansServiceBlockingStub.fetchLoanDetailsProto(stringValue);
    }
}
