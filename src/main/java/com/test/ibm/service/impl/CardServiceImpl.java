package com.test.ibm.service.impl;

import com.test.ibm.converter.CardConverter;
import com.test.ibm.dto.CardDto;
import com.test.ibm.repository.CardRepository;
import com.test.ibm.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public void save(CardDto cardDto) {
        cardRepository.save(CardConverter.dtoToEntity(cardDto));
    }

    @Override
    public void delete(CardDto cardDto) {
        cardRepository.delete(CardConverter.dtoToEntity(cardDto));
    }

    @Override
    public List<CardDto> list() {
        return CardConverter.entityToDto(cardRepository.list());
    }

    @Override
    public void update(CardDto cardDto) {
        cardRepository.update(CardConverter.dtoToEntity(cardDto));
    }
}
