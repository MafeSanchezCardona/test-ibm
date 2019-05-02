package com.test.ibm.repository;

import com.test.ibm.entity.Transaction;

import java.util.List;

/**
 * Class for get data of the entity Transaction
 */
public interface TransactionRepository {

    /**
     * Method for created a transaction
     * @param transaction
     */
    void save(Transaction transaction);

    /**
     * Method for deleted a transaction
     * @param transaction
     */
    void delete(Transaction transaction);

    /**
     * Method for get all transactions
     * @return
     */
    List<Transaction> list();

    /**
     * Method for updated a transaction
     * @param transaction
     */
    void update(Transaction transaction);

    /**
     * Method for get all transactions by customer
     * @param customerIdentification
     * @return
     */
    List<Transaction> listByCustomer(Long customerIdentification);
}
