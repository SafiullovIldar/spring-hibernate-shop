package ru.spring.hibernate.shop.dao;

import ru.spring.hibernate.shop.entity.Customer;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public interface CustomerDao {

    void createCustomer(Customer customer);
    List getAllCustomers();
    Customer getCustomerById(String customerId);
}
