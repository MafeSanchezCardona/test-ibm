package com.test.ibm.repository.impl;

import com.test.ibm.entity.Card;
import com.test.ibm.repository.CardRepository;
import com.test.ibm.utility.HibernateUtility;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class CardRepositoryImpl implements CardRepository {
    @Override
    public void save(Card card) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(card);

        session.getTransaction().commit();
        HibernateUtility.shutdown();
    }

    @Override
    public void delete(Card card) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(card);

        session.getTransaction().commit();
        HibernateUtility.shutdown();
    }

    @Override
    public List<Card> list() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        List<Card> cardList = session.createQuery("from Card").list();

        session.getTransaction().commit();
        HibernateUtility.shutdown();

        return cardList;
    }

    @Override
    public void update(Card card) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(card);

        session.getTransaction().commit();
        HibernateUtility.shutdown();
    }
}
