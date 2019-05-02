package com.test.ibm.service;

import com.test.ibm.dto.TransactionDto;

import java.text.ParseException;
import java.util.List;

/**
 * Class for business logic of the Transaction
 */
public interface TransactionService {

    /**
     * Method for created a transaction
     * @param transactionDto
     */
    void save(TransactionDto transactionDto);

    /**
     * Method for deleted a transaction
     * @param transactionDto
     */
    void delete(TransactionDto transactionDto);

    /**
     * Method for get all transactions
     * @return
     * @throws ParseException
     */
    List<TransactionDto> list() throws ParseException;

    /**
     * Method for updated a transaction
     * @param transactionDto
     */
    void update(TransactionDto transactionDto);

    /**
     * Method for get all transactions by customer
     * @param customerIdentification
     * @return
     * @throws ParseException
     */
    List<TransactionDto> listByCustomer(Long customerIdentification) throws ParseException;
}
