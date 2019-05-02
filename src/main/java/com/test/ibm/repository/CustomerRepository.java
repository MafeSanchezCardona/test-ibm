package com.test.ibm.repository;

import com.test.ibm.entity.Customer;

import java.util.List;

/**
 * Class for get data of the entity Customer
 */
public interface CustomerRepository {

    /**
     * Method for created a customer
     * @param customer
     */
    void save(Customer customer);

    /**
     * Method for deleted a customer
     * @param customer
     */
    void delete(Customer customer);

    /**
     * Method for get all customers
     * @return
     */
    List<Customer> list();

    /**
     * Method for updated a customer
     * @param customer
     */
    void update(Customer customer);
}
