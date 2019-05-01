package com.test.ibm.repository.impl;

import com.test.ibm.entity.Customer;
import com.test.ibm.repository.CustomerRepository;
import com.test.ibm.utility.HibernateUtility;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public void save(Customer customer) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(customer);

        session.getTransaction().commit();
        HibernateUtility.shutdown();
    }

    @Override
    public void delete(Customer customer) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(customer);

        session.getTransaction().commit();
        HibernateUtility.shutdown();
    }

    @Override
    public List<Customer> list() {

        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        List<Customer> customerList = session.createQuery("from Customer").list();

        session.getTransaction().commit();
        HibernateUtility.shutdown();

        return customerList;
    }

    @Override
    public void update(Customer customer) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(customer);

        session.getTransaction().commit();
        HibernateUtility.shutdown();
    }
}
