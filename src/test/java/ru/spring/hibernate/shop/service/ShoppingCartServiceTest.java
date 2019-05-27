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
import ru.spring.hibernate.shop.dao.PurchaseDao;
import ru.spring.hibernate.shop.dao.ShoppingCartDao;
import ru.spring.hibernate.shop.dto.ShoppingCartDto;
import ru.spring.hibernate.shop.entity.ShoppingCart;
import ru.spring.hibernate.shop.util.Util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class ShoppingCartServiceTest {

    @Autowired
    private ConversionService conversionService;

    @Mock
    private PurchaseDao purchaseDao;

    @Mock
    private ShoppingCartDao shoppingCartDao;

    @Autowired
    @InjectMocks
    private ShoppingCartService shoppingCartService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnShoppingCartWithExpectedShoppingCartId() throws ParseException {
        ShoppingCartDto shoppingCartDto = Util.createTestShoppingCart("1");
        ShoppingCart shoppingCart = conversionService.convert(shoppingCartDto, ShoppingCart.class);

        when(shoppingCartDao.getShoppingCartById("1")).thenReturn(shoppingCart);

        assertEquals("1", shoppingCartService.getShoppingCartDtoById("1").getId());
    }

    @Test
    public void shouldPrintCorrectMessageDependingOnPaymentMethod() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        shoppingCartService.pay("1", "1");
        assertThat(outContent.toString(), containsString("paid using credit card"));

        shoppingCartService.pay("1", "2");
        assertThat(outContent.toString(), containsString("paid using PayPal"));

        shoppingCartService.pay("1", "3");
        assertThat(outContent.toString(), containsString("There is no payment information"));

    }
}