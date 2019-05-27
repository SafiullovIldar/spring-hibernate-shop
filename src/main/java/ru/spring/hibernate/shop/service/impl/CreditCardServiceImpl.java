package ru.spring.hibernate.shop.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.spring.hibernate.shop.dao.CreditCardDao;
import ru.spring.hibernate.shop.dto.CreditCardDto;
import ru.spring.hibernate.shop.entity.CreditCard;
import ru.spring.hibernate.shop.service.CreditCardService;

@Service
@AllArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

    private ConversionService conversion;
    private CreditCardDao creditCardDao;

    @Override
    public void createCreditCard(CreditCardDto dto) {
        CreditCard creditCard = conversion.convert(dto, CreditCard.class);
        creditCardDao.createCreditCard(creditCard);
    }

    @Override
    public CreditCardDto getCreditCard(String creditCardId) {
        CreditCard creditCard = creditCardDao.getCreditCard(creditCardId);
        return conversion.convert(creditCard, CreditCardDto.class);
    }

    @Override
    public CreditCardDto getCreditCardByCustomerId(String customerId) {
        CreditCard creditCard = creditCardDao.getCreditCardByCustomerId(customerId);
        return conversion.convert(creditCard, CreditCardDto.class);
    }
}
