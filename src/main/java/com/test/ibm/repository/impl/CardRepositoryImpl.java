package com.test.ibm.repository.impl;

import com.test.ibm.entity.Card;
import com.test.ibm.repository.CardRepository;
import com.test.ibm.utility.HibernateUtility;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardRepositoryImpl implements CardRepository {

    @Override
    public void save(Card card) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(card);

        session.getTransaction().commit();
    }

    @Override
    public void delete(Card card) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        StringBuilder deleteQuery = new StringBuilder("DELETE FROM Card WHERE NUMBER = ").append(card.getNumber());

        session.createQuery(deleteQuery.toString()).executeUpdate();

        session.getTransaction().commit();
    }

    @Override
    public List<Card> list(Long customerIdentification) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        StringBuilder selectQuery = new StringBuilder("FROM Card WHERE CUSTOMER_IDENTIFICATION = ").append(customerIdentification);

        List<Card> cardList = session.createQuery(selectQuery.toString()).list();

        session.getTransaction().commit();

        return cardList;
    }

    @Override
    public void update(Card card) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(card);

        session.getTransaction().commit();
    }
}
