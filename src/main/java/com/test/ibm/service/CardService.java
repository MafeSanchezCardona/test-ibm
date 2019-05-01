package com.test.ibm.service;

import com.test.ibm.dto.CardDto;

import java.util.List;

public interface CardService {

    void save(CardDto cardDto);

    void delete(CardDto cardDto);

    List<CardDto> list();

    void update(CardDto cardDto);
}
