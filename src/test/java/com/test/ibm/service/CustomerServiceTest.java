package com.test.ibm.service;

import com.test.ibm.entity.Customer;
import com.test.ibm.repository.CustomerRepository;
import com.test.ibm.repository.impl.CustomerRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Before
    public void setUp() {
        Customer customer = new Customer();
        customer.setIdentification(12131L);
        customer.setName("Mafe");
        customer.setAddress("Calle 20");
        customer.setCity("Medellin");
        customer.setTelephone(2432L);

        customerRepository.save(customer);
    }

    @Test
    public void getAllCustomers() {
        Assert.assertNotNull(customerRepository.list());
    }
}
