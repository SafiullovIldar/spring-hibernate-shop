package ru.spring.hibernate.shop.converter.dtotoentity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.PromoCodeDto;
import ru.spring.hibernate.shop.entity.PromoCode;

@Component
public class PromoCodeDtoToPromoCode implements Converter<PromoCodeDto, PromoCode> {

    @Override
    public PromoCode convert(PromoCodeDto promoCodeDto) {
        PromoCode promoCode = new PromoCode();
        promoCode.setId(promoCodeDto.getId());
        promoCode.setExpirationDate(promoCodeDto.getExpirationDate());
        promoCode.setDiscount(promoCodeDto.getDiscount());
        promoCode.setItem(promoCodeDto.getItem());
        return promoCode;
    }
}
