package com.test.ibm.controller;

import com.test.ibm.dto.CustomerDto;
import com.test.ibm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<String> save(@RequestBody CustomerDto customerDto) {
        customerService.save(customerDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<String> update(@RequestBody CustomerDto customerDto) {
        customerService.update(customerDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<String> delete(@RequestBody CustomerDto customerDto) {
        customerService.delete(customerDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/list")
    public ResponseEntity<List<CustomerDto>> list() {
        return new ResponseEntity<>(customerService.list(), HttpStatus.OK);
    }
}
