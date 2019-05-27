package ru.spring.hibernate.shop.service;

import org.springframework.stereotype.Service;
import ru.spring.hibernate.shop.dto.CreditCardDto;

@Service
public interface CreditCardService {

    void createCreditCard(CreditCardDto dto);
    CreditCardDto getCreditCard(String creditCardId);
    CreditCardDto getCreditCardByCustomerId(String customerId);

}
