package com.test.ibm.repository;

import com.test.ibm.entity.Customer;

import java.util.List;

public interface CustomerRepository {

    void save(Customer customer);

    void delete(Customer customer);

    List<Customer> list();

    void update(Customer customer);
}
