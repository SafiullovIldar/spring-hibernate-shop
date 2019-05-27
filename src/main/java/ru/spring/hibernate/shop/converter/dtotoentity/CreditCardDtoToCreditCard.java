package ru.spring.hibernate.shop.converter.dtotoentity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.CreditCardDto;
import ru.spring.hibernate.shop.entity.CreditCard;
import ru.spring.hibernate.shop.entity.Customer;

@Component
public class CreditCardDtoToCreditCard implements Converter<CreditCardDto, CreditCard> {

    @Override
    public CreditCard convert(CreditCardDto dto) {
        CreditCard creditCard = new CreditCard();
        creditCard.setId(dto.getId());
        creditCard.setCardNumber(dto.getCardNumber());
        creditCard.setCvsNumber(dto.getCvsNumber());
        creditCard.setExpirationDate(dto.getExpirationDate());
        creditCard.setCustomer(dto.getCustomer());
        return creditCard;
    }
}
