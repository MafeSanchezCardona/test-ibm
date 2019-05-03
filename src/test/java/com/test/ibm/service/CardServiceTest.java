package com.test.ibm.service;

import com.test.ibm.entity.Card;
import com.test.ibm.repository.CardRepository;
import com.test.ibm.repository.impl.CardRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CardServiceTest {

    @Autowired
    private CardRepository cardRepository = new CardRepositoryImpl();

    @Before
    public void setUp() {
        Card card = new Card();
        card.setNumber(12132431L);
        card.setCcv(234);
        card.setType("Tipo 1");
        card.setCustomerIdentification(1L);

        cardRepository.save(card);
    }

    @Test
    public void getAllCards() {
        Assert.assertNotNull(cardRepository.list(1L));
    }

}
