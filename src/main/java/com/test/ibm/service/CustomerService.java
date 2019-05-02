package com.test.ibm.service;

import com.test.ibm.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    void save(CustomerDto customerDto);

    void delete(CustomerDto customerDto);

    List<CustomerDto> list();

    void update(CustomerDto customerDto);
}
