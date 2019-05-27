package ru.spring.hibernate.shop.converter.entitytodto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.ItemDto;
import ru.spring.hibernate.shop.dto.PromoCodeDto;
import ru.spring.hibernate.shop.entity.PromoCode;

@Component
public class PromoCodeToPromoCodeDto implements Converter<PromoCode, PromoCodeDto> {

    @Override
    public PromoCodeDto convert(PromoCode promoCode) {
        PromoCodeDto dto = new PromoCodeDto();
        dto.setId(promoCode.getId());
        dto.setDiscount(promoCode.getDiscount());
        dto.setExpirationDate(promoCode.getExpirationDate());
        dto.setItem(promoCode.getItem());
        return dto;
    }
}
