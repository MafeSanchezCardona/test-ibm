package com.test.ibm.service;

import com.test.ibm.dto.TransactionDto;

import java.util.List;

public interface TransactionService {

    void save(TransactionDto transactionDto);

    void delete(TransactionDto transactionDto);

    List<TransactionDto> list();

    void update(TransactionDto transactionDto);

    List<TransactionDto> listByCustomer(Long customerIdentification);
}
