package ru.spring.hibernate.shop.dao;


import ru.spring.hibernate.shop.entity.PromoCode;
import org.springframework.stereotype.Component;

@Component
public interface PromoCodeDao {

    PromoCode getPromoCode(String promoCodeId);
    void createPromoCode(PromoCode promoCode);

}
