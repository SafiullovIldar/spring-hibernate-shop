package ru.spring.hibernate.shop.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.spring.hibernate.shop.dao.CustomerDao;
import ru.spring.hibernate.shop.dto.CustomerDto;
import ru.spring.hibernate.shop.dto.ShoppingCartDto;
import ru.spring.hibernate.shop.entity.Customer;
import ru.spring.hibernate.shop.service.CustomerService;
import ru.spring.hibernate.shop.service.ShoppingCartService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;
    private ShoppingCartService shoppingCartService;
    private ConversionService conversion;

    @Override
    public void createCustomer(CustomerDto dto) {
        Customer customer = conversion.convert(dto, Customer.class);
        customerDao.createCustomer(customer);
        shoppingCartService.createShoppingCart(new ShoppingCartDto(), customer.getId());
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> allCustomers = customerDao.getAllCustomers();
        List<CustomerDto> customerDtos = new ArrayList<>();

        for (Customer allCustomer : allCustomers) {
            customerDtos.add(conversion.convert(allCustomer, CustomerDto.class));
        }

        return customerDtos;
    }

    @Override
    public CustomerDto getCustomerById(String customerId) {
        Customer customer = customerDao.getCustomerById(customerId);
        return conversion.convert(customer, CustomerDto.class );
    }
}
