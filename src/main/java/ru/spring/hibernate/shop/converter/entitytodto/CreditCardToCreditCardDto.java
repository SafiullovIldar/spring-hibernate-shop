package ru.spring.hibernate.shop.converter.entitytodto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.CreditCardDto;
import ru.spring.hibernate.shop.entity.CreditCard;

@Component
public class CreditCardToCreditCardDto implements Converter<CreditCard, CreditCardDto> {

    @Override
    public CreditCardDto convert(CreditCard creditCard) {
        CreditCardDto dto = new CreditCardDto();
        dto.setId(creditCard.getId());
        dto.setCardNumber(creditCard.getCardNumber());
        dto.setCvsNumber(creditCard.getCvsNumber());
        dto.setExpirationDate(creditCard.getExpirationDate());
        dto.setCustomer(creditCard.getCustomer());
        return dto;
    }
}
