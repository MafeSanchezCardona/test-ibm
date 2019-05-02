package com.test.ibm.repository;

import com.test.ibm.entity.Card;

import java.util.List;

public interface CardRepository {

    void save(Card card);

    void delete(Card card);

    List<Card> list(Long customerIdentification);

    void update(Card card);
}
