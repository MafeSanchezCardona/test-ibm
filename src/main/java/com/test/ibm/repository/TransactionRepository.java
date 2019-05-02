package com.test.ibm.repository;

import com.test.ibm.entity.Transaction;

import java.util.List;

public interface TransactionRepository {
    void save(Transaction transaction);

    void delete(Transaction transaction);

    List<Transaction> list();

    void update(Transaction transaction);

    List<Transaction> listByCustomer(Long customerIdentification);
}
