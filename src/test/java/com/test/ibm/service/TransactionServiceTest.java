package com.test.ibm.service;

import com.test.ibm.entity.Customer;
import com.test.ibm.entity.Transaction;
import com.test.ibm.repository.CustomerRepository;
import com.test.ibm.repository.TransactionRepository;
import com.test.ibm.repository.impl.CustomerRepositoryImpl;
import com.test.ibm.repository.impl.TransactionRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class TransactionServiceTest {

    @Autowired
    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Autowired
    private TransactionRepository transactionRepository = new TransactionRepositoryImpl();

    @Before
    public void setUp() {

        Customer customer = new Customer();
        customer.setIdentification(121313242L);
        customer.setName("Mafe");
        customer.setAddress("Calle 20");
        customer.setCity("Medellin");
        customer.setTelephone(2432L);

        customerRepository.save(customer);

        Transaction transaction = new Transaction();
        transaction.setDescription("Prueba de Consumo");
        transaction.setAmount(100D);
        transaction.setDate(new Date());
        transaction.setCardNumber(189763535L);

        transactionRepository.save(transaction);
    }

    @Test
    public void getTransactionsByCustomer() {
        Assert.assertNotNull(transactionRepository.listByCustomer(121313242L));
    }
}
