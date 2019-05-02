package com.test.ibm.service;

import com.test.ibm.dto.TransactionDto;

import java.text.ParseException;
import java.util.List;

public interface TransactionService {

    void save(TransactionDto transactionDto);

    void delete(TransactionDto transactionDto);

    List<TransactionDto> list() throws ParseException;

    void update(TransactionDto transactionDto);

    List<TransactionDto> listByCustomer(Long customerIdentification) throws ParseException;
}
