package ru.spring.hibernate.shop.dao;

import ru.spring.hibernate.shop.entity.CreditCard;
import org.springframework.stereotype.Component;

@Component
public interface CreditCardDao {

    void createCreditCard(CreditCard creditCard);
    CreditCard getCreditCard(String creditCardId);
    CreditCard getCreditCardByCustomerId(String customerId);
}
