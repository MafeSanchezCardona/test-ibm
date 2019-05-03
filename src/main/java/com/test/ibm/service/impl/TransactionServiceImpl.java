package com.test.ibm.service.impl;

import com.test.ibm.converter.TransactionConverter;
import com.test.ibm.dto.TransactionDto;
import com.test.ibm.exception.TestIbmException;
import com.test.ibm.repository.TransactionRepository;
import com.test.ibm.service.TransactionService;
import com.test.ibm.service.CardService;
import org.apache.commons.lang.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CardService cardService;

    @Override
    public void save(TransactionDto transactionDto) {

        boolean isExistsCardNumber = cardService.existsCardNumber(transactionDto.getCardNumber());

        if (BooleanUtils.isNotTrue(isExistsCardNumber)) {
            throw new TestIbmException("Error en la creacion de un consumo, ya que el numero de la tarjeta no existe");
        }

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
