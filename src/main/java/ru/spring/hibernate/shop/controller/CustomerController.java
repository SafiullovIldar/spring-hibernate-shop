package ru.spring.hibernate.shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.spring.hibernate.shop.dto.CustomerDto;
import ru.spring.hibernate.shop.service.CustomerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("customer")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping()
    public void createCustomer(@RequestBody CustomerDto dto) {
        customerService.createCustomer(dto);
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable("id") String customerId) {
        return customerService.getCustomerById(customerId);
    }
}
