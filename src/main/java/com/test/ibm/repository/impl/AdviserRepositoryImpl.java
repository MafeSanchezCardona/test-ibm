package com.test.ibm.repository.impl;

import com.test.ibm.entity.Adviser;
import com.test.ibm.repository.AdviserRepository;
import com.test.ibm.utility.HibernateUtility;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdviserRepositoryImpl implements AdviserRepository {

    @Override
    public void save(Adviser adviser) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(adviser);

        session.getTransaction().commit();
    }

    @Override
    public void delete(Adviser adviser) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        StringBuilder deleteQuery = new StringBuilder("DELETE FROM Adviser WHERE IDENTIFICATION = ").append(adviser.getIdentification());

        session.createQuery(deleteQuery.toString()).executeUpdate();

        session.getTransaction().commit();
    }

    @Override
    public List<Adviser> list() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        List<Adviser> adviserList = session.createQuery("from Adviser").list();

        session.getTransaction().commit();

        return adviserList;
    }

    @Override
    public void update(Adviser adviser) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(adviser);

        session.getTransaction().commit();
    }
}
