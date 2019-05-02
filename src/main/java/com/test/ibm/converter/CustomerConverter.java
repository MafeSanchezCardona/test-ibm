package com.test.ibm.converter;

import com.test.ibm.dto.CustomerDto;
import com.test.ibm.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerConverter {

    public static Customer dtoToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setIdentification(customerDto.getIdentification());
        customer.setName(customerDto.getName());
        customer.setAddress(customerDto.getAddress());
        customer.setCity(customerDto.getCity());
        customer.setTelephone(customerDto.getTelephone());
        return customer;
    }

    public static List<CustomerDto> entityToDto(List<Customer> customerList) {

        List<CustomerDto> customerDtoList = new ArrayList<>();
        CustomerDto customerDto;
        for (Customer customer : customerList) {
            customerDto = new CustomerDto();
            customerDto.setIdentification(customer.getIdentification());
            customerDto.setName(customer.getName());
            customerDto.setAddress(customer.getAddress());
            customerDto.setCity(customer.getCity());
            customerDto.setTelephone(customer.getTelephone());
            customerDto.setCardNumbers(customer.getCardNumbers());
            customerDtoList.add(customerDto);
        }

        return customerDtoList;
    }
}
