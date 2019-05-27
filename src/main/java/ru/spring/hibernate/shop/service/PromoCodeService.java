package ru.spring.hibernate.shop.service;

import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.PromoCodeDto;

@Component
public interface PromoCodeService {

    PromoCodeDto getPromoCode(String promoCodeId);
    void createPromoCode(PromoCodeDto dto);
}
