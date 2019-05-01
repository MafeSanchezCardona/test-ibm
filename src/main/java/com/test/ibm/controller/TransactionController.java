package com.test.ibm.controller;

import com.test.ibm.dto.TransactionDto;
import com.test.ibm.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody TransactionDto transactionDto) {
        transactionService.save(transactionDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(@RequestBody TransactionDto transactionDto) {
        transactionService.update(transactionDto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody TransactionDto transactionDto) {
        transactionService.delete(transactionDto);
    }

    @RequestMapping(value = "/list")
    public List<TransactionDto> list() {
        return transactionService.list();
    }

    @RequestMapping(value = "/list-by-customer")
    public List<TransactionDto> list(@RequestBody Long customerIdentification ) {
        return transactionService.listByCustomer(customerIdentification);
    }

}
