package com.test.ibm.service;

import com.test.ibm.dto.CustomerDto;

import java.util.List;

/**
 * Class for business logic of the Customer
 */
public interface CustomerService {

    /**
     * Method for created a customer
     * @param customerDto
     */
    void save(CustomerDto customerDto);

    /**
     * Method for deleted a customer
     * @param customerDto
     */
    void delete(CustomerDto customerDto);

    /**
     * Method for get all customers
     * @return
     */
    List<CustomerDto> list();

    /**
     * Method for updated a customer
     * @param customerDto
     */
    void update(CustomerDto customerDto);
}
