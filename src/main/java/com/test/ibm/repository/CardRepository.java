package com.test.ibm.repository;

import com.test.ibm.entity.Card;

import java.util.List;

/**
 * Class for get data of the entity Card
 */
public interface CardRepository {

    /**
     * Method for created a card
     * @param card
     */
    void save(Card card);

    /**
     * Method for deleted a card
     * @param card
     */
    void delete(Card card);

    /**
     * Method for get all cards by customer
     * @param customerIdentification
     * @return
     */
    List<Card> list(Long customerIdentification);

    /**
     * Method for updated a card
     * @param card
     */
    void update(Card card);
}
