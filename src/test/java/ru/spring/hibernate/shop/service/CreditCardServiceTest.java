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
import ru.spring.hibernate.shop.dao.CreditCardDao;
import ru.spring.hibernate.shop.dto.CreditCardDto;
import ru.spring.hibernate.shop.entity.CreditCard;
import ru.spring.hibernate.shop.util.Util;

import java.text.ParseException;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class CreditCardServiceTest {

    @Autowired
    private ConversionService conversionService;

    @Mock
    private CreditCardDao creditCardDao;

    @Autowired
    @InjectMocks
    private CreditCardService creditCardService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenCreateCreditCardCalledVerified() throws ParseException {
        CreditCardDto creditCardDto = Util.createTestCreditCard("1");
        CreditCard creditCard = conversionService.convert(creditCardDto, CreditCard.class);

        doNothing().when(creditCardDao).createCreditCard(creditCard);
        creditCardService.createCreditCard(creditCardDto);

        verify(creditCardDao, times(1)).createCreditCard(creditCard);
    }
}