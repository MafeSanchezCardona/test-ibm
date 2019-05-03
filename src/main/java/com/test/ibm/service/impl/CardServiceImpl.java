package com.test.ibm.service.impl;

import com.test.ibm.converter.CardConverter;
import com.test.ibm.dto.CardDto;
import com.test.ibm.exception.TestIbmException;
import com.test.ibm.repository.CardRepository;
import com.test.ibm.service.CardService;
import com.test.ibm.service.CustomerService;
import org.apache.commons.lang.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CustomerService customerService;

    @Override
    public void save(CardDto cardDto) {

        boolean existsCustomer = customerService.existsCustomer(cardDto.getCustomerIdentification());

        if (BooleanUtils.isNotTrue(existsCustomer)) {
            throw new TestIbmException("Error en la creacion de una tarjeta, ya que la cedula del cliente no existe");
        }

        cardRepository.save(CardConverter.dtoToEntity(cardDto));
    }

    @Override
    public void delete(CardDto cardDto) {
        cardRepository.delete(CardConverter.dtoToEntity(cardDto));
    }

    @Override
    public List<CardDto> list(Long customerIdentification) {
        return CardConverter.entityToDto(cardRepository.list(customerIdentification));
    }

    @Override
    public void update(CardDto cardDto) {
        cardRepository.update(CardConverter.dtoToEntity(cardDto));
    }

    @Override
    public boolean existsCardNumber(Long number) {
        return cardRepository.existsCardNumber(number);
    }
}
