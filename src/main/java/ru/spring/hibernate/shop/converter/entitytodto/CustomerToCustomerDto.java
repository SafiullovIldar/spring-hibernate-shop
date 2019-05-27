package ru.spring.hibernate.shop.converter.entitytodto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.CustomerDto;
import ru.spring.hibernate.shop.entity.Customer;

@Component
public class CustomerToCustomerDto implements Converter<Customer, CustomerDto> {

    @Override
    public CustomerDto convert(Customer customer) {
        CustomerDto dto = new CustomerDto();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setAddress(customer.getAddress());
        dto.setEmail(customer.getEmail());
        dto.setPhoneNumber(customer.getPhoneNumber());
        return dto;
    }
}
