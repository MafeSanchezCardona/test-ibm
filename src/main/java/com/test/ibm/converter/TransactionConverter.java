package com.test.ibm.converter;

import com.test.ibm.dto.TransactionDto;
import com.test.ibm.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionConverter {

    public static Transaction dtoToEntity(TransactionDto transactionDto) {

        Transaction transaction = new Transaction();
        transaction.setId(transactionDto.getId());
        transaction.setCardNumber(transactionDto.getCardNumber());
        transaction.setDescription(transactionDto.getDescription());
        transaction.setDate(transactionDto.getDate());
        transaction.setAmount(transactionDto.getAmount());
        return transaction;
    }

    public static List<TransactionDto> entityToDto(List<Transaction> transactionList) {

        List<TransactionDto> transactionDtoList = new ArrayList<>();
        TransactionDto transactionDto;
        for (Transaction transaction : transactionList) {
            transactionDto = new TransactionDto();
            transactionDto.setId(transaction.getId());
            transactionDto.setCardNumber(transaction.getCardNumber());
            transactionDto.setDescription(transaction.getDescription());
            transactionDto.setDate(transaction.getDate());
            transactionDto.setAmount(transaction.getAmount());
            transactionDtoList.add(transactionDto);
        }

        return transactionDtoList;
    }
}
