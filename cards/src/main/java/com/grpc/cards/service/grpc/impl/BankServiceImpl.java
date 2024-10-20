package com.grpc.cards.service.grpc.impl;

import com.bank.Bank;
import com.bank.CardsServiceGrpc;
import com.grpc.cards.mapper.CardsMapper;
import com.grpc.cards.repository.CardsRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class BankServiceImpl extends CardsServiceGrpc.CardsServiceImplBase {

    private final CardsRepository cardsRepository;

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void fetchCardDetailsProto(Bank.StringValue request, StreamObserver<Bank.CardsDto> responseObserver) {
        cardsRepository.findByCardNumber(request.getValue())
                .map(CardsMapper::mapToCardsDtoProto)
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }
}
