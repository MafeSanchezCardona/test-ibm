package com.test.ibm.controller;

import com.test.ibm.dto.TransactionDto;
import com.test.ibm.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.util.List;

/**
 * Class that is the controller of the Transaction
 */
@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    /**
     * Method for load the view transaction
     * @return
     */
    @RequestMapping("/load")
    public String load() {
        return "transaction";
    }

    /**
     * Method for created a transaction
     * @param transactionDto
     * @return ResponseEntity<String>
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody TransactionDto transactionDto) {
        transactionService.save(transactionDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Method for updated a transaction
     * @param transactionDto
     * @return ResponseEntity<String>
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<String> update(@RequestBody TransactionDto transactionDto) {
        transactionService.update(transactionDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Method for deleted a transaction
     * @param transactionDto
     * @return ResponseEntity<String>
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<String> delete(@RequestBody TransactionDto transactionDto) {
        transactionService.delete(transactionDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Method for get all transactions
     * @return ResponseEntity<List<TransactionDto>>
     * @throws ParseException
     */
    @RequestMapping(value = "/list")
    public ResponseEntity<List<TransactionDto>> list() throws ParseException {
        return new ResponseEntity<>(transactionService.list(), HttpStatus.OK);
    }

    /**
     * Method for get all transactions by customer
     * @param customerIdentification
     * @return ResponseEntity<List<TransactionDto>>
     * @throws ParseException
     */
    @RequestMapping(value = "/list-by-customer")
    public ResponseEntity<List<TransactionDto>> list(@RequestBody Long customerIdentification ) throws ParseException {
        return new ResponseEntity<>(transactionService.listByCustomer(customerIdentification), HttpStatus.OK);
    }

}
