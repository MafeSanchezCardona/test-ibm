package com.test.ibm.service.impl;

import com.test.ibm.converter.CustomerConverter;
import com.test.ibm.dto.CustomerDto;
import com.test.ibm.repository.CustomerRepository;
import com.test.ibm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void save(CustomerDto customerDto) {
        customerRepository.save(CustomerConverter.dtoToEntity(customerDto));
    }

    @Override
    public void delete(CustomerDto customerDto) {
        customerRepository.delete(CustomerConverter.dtoToEntity(customerDto));
    }

    @Override
    public List<CustomerDto> list() {
        return CustomerConverter.entityToDto(customerRepository.list());
    }

    @Override
    public void update(CustomerDto customerDto) {
        customerRepository.update(CustomerConverter.dtoToEntity(customerDto));
    }
}
