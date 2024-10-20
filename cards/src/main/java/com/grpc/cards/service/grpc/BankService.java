package com.grpc.cards.service.grpc;

import com.grpc.cards.dto.CardsDto;

public interface BankService {

    CardsDto getCardsProto(String mobileNumber);
}
