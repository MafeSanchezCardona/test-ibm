package com.test.ibm.repository.impl;

import com.test.ibm.entity.Customer;
import com.test.ibm.repository.CustomerRepository;
import com.test.ibm.utility.HibernateUtility;
import org.apache.commons.lang.BooleanUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public void save(Customer customer) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(customer);

        session.getTransaction().commit();
    }

    @Override
    public void delete(Customer customer) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        StringBuilder deleteQuery = new StringBuilder("DELETE FROM Customer WHERE IDENTIFICATION = ").append(customer.getIdentification());

        session.createQuery(deleteQuery.toString()).executeUpdate();

        session.getTransaction().commit();
    }

    @Override
    public List<Customer> list() {

        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        StringBuilder selectQuery = new StringBuilder("SELECT ")
                .append("Customer.IDENTIFICATION AS identification,")
                .append("Customer.NAME AS name,")
                .append("Customer.ADDRESS AS address,")
                .append("Customer.CITY AS city,")
                .append("Customer.TELEPHONE AS telephone,")
                .append("(SELECT GROUP_CONCAT(Card.NUMBER) FROM Card WHERE Card.CUSTOMER_IDENTIFICATION = Customer.IDENTIFICATION) AS cardNumbers ")
                .append("FROM Customer ");

        SQLQuery query = session.createSQLQuery(selectQuery.toString());
        query.addEntity(Customer.class);
        List<Customer> customerList = query.list();

        session.getTransaction().commit();

        return customerList;
    }

    @Override
    public void update(Customer customer) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(customer);

        session.getTransaction().commit();
    }

    @Override
    public boolean existsCustomer(Long identification) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        StringBuilder selectQuery = new StringBuilder();
        selectQuery.append("FROM Customer WHERE IDENTIFICATION = ").append(identification);

        Customer customer = (Customer) session.createQuery(selectQuery.toString()).uniqueResult();

        session.getTransaction().commit();

        return BooleanUtils.toBoolean(customer != null);
    }
}
