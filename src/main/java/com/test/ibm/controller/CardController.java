package com.test.ibm.controller;

import com.test.ibm.dto.CardDto;
import com.test.ibm.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping("/load")
    public String load() {
        return "card";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody CardDto cardDto) {
        cardService.save(cardDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<String> update(@RequestBody CardDto cardDto) {
        cardService.update(cardDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<String> delete(@RequestBody CardDto cardDto) {
        cardService.delete(cardDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/list")
    public ResponseEntity<List<CardDto>> list(@RequestBody Long customerIdentification) {
        return new ResponseEntity<>(cardService.list(customerIdentification), HttpStatus.OK);
    }
}
