package com.test.ibm.converter;

import com.test.ibm.dto.CardDto;
import com.test.ibm.entity.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that helps convert DTO to Entity or vice versa
 */
public class CardConverter {

    /**
     * Method that convert DTO to Entity
     * @param cardDto
     * @return
     */
    public static Card dtoToEntity(CardDto cardDto) {
        Card card = new Card();
        card.setNumber(cardDto.getNumber());
        card.setCcv(cardDto.getCcv());
        card.setType(cardDto.getType());
        card.setCustomerIdentification(cardDto.getCustomerIdentification());
        return card;
    }

    /**
     * Method that convert Entity List to DTO List
     * @param cardList
     * @return
     */
    public static List<CardDto> entityToDto(List<Card> cardList) {
        List<CardDto> cardDtoList = new ArrayList<>();
        CardDto cardDto;
        for (Card card : cardList) {
            cardDto = new CardDto();
            cardDto.setNumber(card.getNumber());
            cardDto.setCcv(card.getCcv());
            cardDto.setType(card.getType());
            cardDto.setCustomerIdentification(card.getCustomerIdentification());
            cardDtoList.add(cardDto);
        }

        return cardDtoList;
    }
}
