package ru.spring.hibernate.shop.converter.dtotoentity;

import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.CustomerDto;
import ru.spring.hibernate.shop.entity.Customer;
import org.springframework.core.convert.converter.Converter;

@Component
public class CustomerDtoToCustomer implements Converter<CustomerDto, Customer> {

    @Override
    public Customer convert(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setAddress(customerDto.getAddress());
        customer.setEmail(customerDto.getEmail());
        return customer;
    }
}
