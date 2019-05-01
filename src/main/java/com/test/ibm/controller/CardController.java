package com.test.ibm.controller;

import com.test.ibm.dto.CardDto;
import com.test.ibm.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody CardDto cardDto) {
        cardService.save(cardDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(@RequestBody CardDto cardDto) {
        cardService.update(cardDto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody CardDto cardDto) {
        cardService.delete(cardDto);
    }

    @RequestMapping(value = "/list")
    public List<CardDto> list() {
        return cardService.list();
    }
}
