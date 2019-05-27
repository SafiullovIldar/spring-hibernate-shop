package ru.spring.hibernate.shop.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.spring.hibernate.shop.dao.PromoCodeDao;
import ru.spring.hibernate.shop.dto.PromoCodeDto;
import ru.spring.hibernate.shop.entity.PromoCode;
import ru.spring.hibernate.shop.service.PromoCodeService;

@Service
@AllArgsConstructor
public class PromoCodeServiceImpl implements PromoCodeService {

    private PromoCodeDao promoCodeDao;
    private ConversionService conversion;

    @Override
    public PromoCodeDto getPromoCode(String promoCodeId) {
        PromoCode promoCode = promoCodeDao.getPromoCode(promoCodeId);
        return conversion.convert(promoCode, PromoCodeDto.class);
    }

    @Override
    public void createPromoCode(PromoCodeDto dto) {
        PromoCode promoCode = conversion.convert(dto, PromoCode.class);
        promoCodeDao.createPromoCode(promoCode);
    }
}
