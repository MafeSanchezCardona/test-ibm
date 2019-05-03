package com.test.ibm.service;

import com.test.ibm.dto.CardDto;

import java.util.List;

/**
 * Class for business logic of the Card
 */
public interface CardService {

    /**
     * Method for created an card
     * @param cardDto
     */
    void save(CardDto cardDto);

    /**
     * Method for deleted a card
     * @param cardDto
     */
    void delete(CardDto cardDto);

    /**
     * Method for get all cards by customer
     * @param customerIdentification
     * @return
     */
    List<CardDto> list(Long customerIdentification);

    /**
     * Method for updated a card
     * @param cardDto
     */
    void update(CardDto cardDto);

    /**
     * Method for to search if there is a card
     * @param number
     */
    boolean existsCardNumber(Long number);
}
