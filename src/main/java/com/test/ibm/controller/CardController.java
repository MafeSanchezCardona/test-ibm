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

/**
 * Class that is the controller of the Card
 */
@Controller
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    /**
     * Method for load the view Card
     * @return
     */
    @RequestMapping("/load")
    public String load() {
        return "card";
    }

    /**
     * Method for created a card
     * @param cardDto
     * @return ResponseEntity<String>
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody CardDto cardDto) {
        cardService.save(cardDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Method for updated a card
     * @param cardDto
     * @return ResponseEntity<String>
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<String> update(@RequestBody CardDto cardDto) {
        cardService.update(cardDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Method for deleted a card
     * @param cardDto
     * @return ResponseEntity<String>
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<String> delete(@RequestBody CardDto cardDto) {
        cardService.delete(cardDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Method for get all cards
     * @param customerIdentification
     * @return ResponseEntity<List<CardDto>>
     */
    @RequestMapping(value = "/list")
    public ResponseEntity<List<CardDto>> list(@RequestBody Long customerIdentification) {
        return new ResponseEntity<>(cardService.list(customerIdentification), HttpStatus.OK);
    }
}
