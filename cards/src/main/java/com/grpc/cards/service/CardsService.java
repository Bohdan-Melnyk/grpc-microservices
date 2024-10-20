package com.grpc.cards.service;

import com.grpc.cards.dto.CardsDto;

public interface CardsService {

    /**
     *
     * @param mobileNumber
     */
    void createCard(String mobileNumber);

    /**
     *
     * @param mobileNumber
     * @return
     */
    CardsDto fetchCard(String mobileNumber);

    /**
     *
     * @param cardsDto
     * @return
     */
    boolean updateCard(CardsDto cardsDto);

    /**
     *
     * @param mobileNumber
     * @return
     */
    boolean deleteCard(String mobileNumber);

    CardsDto fetchCardProto(String mobileNumber);
}
