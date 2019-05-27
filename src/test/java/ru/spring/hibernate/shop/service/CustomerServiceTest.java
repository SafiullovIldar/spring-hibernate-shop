package ru.spring.hibernate.shop.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.spring.hibernate.shop.config.AppConfig;
import ru.spring.hibernate.shop.dao.CustomerDao;
import ru.spring.hibernate.shop.dto.CustomerDto;
import ru.spring.hibernate.shop.entity.Customer;
import ru.spring.hibernate.shop.util.Util;

import java.sql.SQLException;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class CustomerServiceTest {

    @Autowired
    ConversionService conversionService;

    @Mock
    private CustomerDao customerDao;

    @Autowired
    @InjectMocks
    private CustomerService customerService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenCreateCustomerCalledVerified() throws SQLException {
        CustomerDto customerDto = Util.createTestCustomer("1");
        Customer customer = conversionService.convert(customerDto, Customer.class);

        doNothing().when(customerDao).createCustomer(customer);
        customerService.createCustomer(customerDto);

        verify(customerDao, times(1)).createCustomer(customer);
    }

    @Test
    public void shouldGetExpectedCustomersCountAndFields() {
        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("TestName");
        customer.setAddress("TestAddress");
        customer.setEmail("TestEmail");
        customer.setPhoneNumber("TestPhone");

        when(customerDao.getAllCustomers()).thenReturn(Collections.singletonList(customer));

        assertEquals(1, customerService.getAllCustomers().size());
        assertEquals("1", customerService.getAllCustomers().get(0).getId());
        assertEquals("TestName", customerService.getAllCustomers().get(0).getName());
        assertEquals("TestEmail", customerService.getAllCustomers().get(0).getEmail());
        assertEquals("TestAddress", customerService.getAllCustomers().get(0).getAddress());
        assertEquals("TestPhone", customerService.getAllCustomers().get(0).getPhoneNumber());
    }
}