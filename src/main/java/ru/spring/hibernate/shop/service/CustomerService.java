package ru.spring.hibernate.shop.service;

import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.CustomerDto;

import java.util.List;

@Component
public interface CustomerService {

    void createCustomer(CustomerDto dto);
    List<CustomerDto> getAllCustomers();
    CustomerDto getCustomerById(String customerId);

}
