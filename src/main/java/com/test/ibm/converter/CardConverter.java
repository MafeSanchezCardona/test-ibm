package com.test.ibm.converter;

import com.test.ibm.dto.CardDto;
import com.test.ibm.entity.Card;

import java.util.ArrayList;
import java.util.List;

public class CardConverter {

    public static Card dtoToEntity(CardDto cardDto) {

        Card card = new Card();
        card.setNumber(cardDto.getNumber());
        card.setCcv(cardDto.getCcv());
        card.setType(cardDto.getType());
        card.setIdentificationCustomer(cardDto.getIdentificationCustomer());
        return card;
    }

    public static List<CardDto> entityToDto(List<Card> cardList) {

        List<CardDto> cardDtoList = new ArrayList<>();
        CardDto cardDto;
        for (Card card : cardList) {
            cardDto = new CardDto();
            cardDto.setNumber(card.getNumber());
            cardDto.setCcv(card.getCcv());
            cardDto.setType(card.getType());
            cardDto.setIdentificationCustomer(card.getIdentificationCustomer());
            cardDtoList.add(cardDto);
        }

        return cardDtoList;
    }
}
