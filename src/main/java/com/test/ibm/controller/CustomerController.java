package com.test.ibm.controller;

import com.test.ibm.dto.CustomerDto;
import com.test.ibm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void save(@RequestBody CustomerDto customerDto) {
        customerService.save(customerDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(@RequestBody CustomerDto customerDto) {
        customerService.update(customerDto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody CustomerDto customerDto) {
        customerService.delete(customerDto);
    }

    @RequestMapping(value = "/list")
    public List<CustomerDto> list() {
        return customerService.list();
    }
}
