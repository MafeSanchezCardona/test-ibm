package com.test.ibm.converter;

import com.test.ibm.dto.TransactionDto;
import com.test.ibm.entity.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class that helps convert DTO to Entity or vice versa
 */
public class TransactionConverter {

    /**
     * Method that convert DTO to Entity
     * @param transactionDto
     * @return
     */
    public static Transaction dtoToEntity(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setId(transactionDto.getId());
        transaction.setCardNumber(transactionDto.getCardNumber());
        transaction.setDescription(transactionDto.getDescription());
        transaction.setDate(transactionDto.getDate());
        transaction.setAmount(transactionDto.getAmount());
        return transaction;
    }

    /**
     * Method that convert Entity List to DTO List
     * @param transactionList
     * @return
     * @throws ParseException
     */
    public static List<TransactionDto> entityToDto(List<Transaction> transactionList) throws ParseException {

        List<TransactionDto> transactionDtoList = new ArrayList<>();
        TransactionDto transactionDto;
        for (Transaction transaction : transactionList) {
            transactionDto = new TransactionDto();
            transactionDto.setId(transaction.getId());
            transactionDto.setCardNumber(transaction.getCardNumber());
            transactionDto.setDescription(transaction.getDescription());
            transactionDto.setAmount(transaction.getAmount());
            transactionDtoList.add(transactionDto);

            //Format Date
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String dateFrom = formatter.format(transaction.getDate());
            transactionDto.setDate(formatter.parse(dateFrom));
        }

        return transactionDtoList;
    }
}
