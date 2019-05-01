package com.test.ibm.repository.impl;

import com.test.ibm.entity.Transaction;
import com.test.ibm.repository.TransactionRepository;
import com.test.ibm.utility.HibernateUtility;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class TransactionRepositoryImpl implements TransactionRepository {
    @Override
    public void save(Transaction transaction) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(transaction);

        session.getTransaction().commit();
        HibernateUtility.shutdown();
    }

    @Override
    public void delete(Transaction transaction) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(transaction);

        session.getTransaction().commit();
        HibernateUtility.shutdown();
    }

    @Override
    public List<Transaction> list() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        List<Transaction> transactionList = session.createQuery("from Transaction").list();

        session.getTransaction().commit();
        HibernateUtility.shutdown();

        return transactionList;
    }

    @Override
    public void update(Transaction transaction) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(transaction);

        session.getTransaction().commit();
        HibernateUtility.shutdown();
    }

    @Override
    public List<Transaction> listByCustomer(Long customerIdentification) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        StringBuilder selectQuery = new StringBuilder();
        selectQuery.append("FROM Transaction transaction ")
                   .append("INNER JOIN Card card ON card.number = transaction.cardNumber ")
                   .append(" AND card.identificationCustomer = ").append(customerIdentification);

        List<Transaction> transactionList = session.createQuery(selectQuery.toString()).list();

        session.getTransaction().commit();
        HibernateUtility.shutdown();

        return transactionList;
    }
}
