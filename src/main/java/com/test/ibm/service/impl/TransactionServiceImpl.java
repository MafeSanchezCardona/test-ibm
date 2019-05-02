package com.test.ibm.service.impl;

import com.test.ibm.converter.TransactionConverter;
import com.test.ibm.dto.TransactionDto;
import com.test.ibm.repository.TransactionRepository;
import com.test.ibm.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void save(TransactionDto transactionDto) {
        transactionRepository.save(TransactionConverter.dtoToEntity(transactionDto));
    }

    @Override
    public void delete(TransactionDto transactionDto) {
        transactionRepository.delete(TransactionConverter.dtoToEntity(transactionDto));
    }

    @Override
    public List<TransactionDto> list() throws ParseException {
        return TransactionConverter.entityToDto(transactionRepository.list());
    }

    @Override
    public void update(TransactionDto transactionDto) {
        transactionRepository.update(TransactionConverter.dtoToEntity(transactionDto));
    }

    @Override
    public List<TransactionDto> listByCustomer(Long customerIdentification) throws ParseException {
        return TransactionConverter.entityToDto(transactionRepository.listByCustomer(customerIdentification));
    }
}
