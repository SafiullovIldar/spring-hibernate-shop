package ru.spring.hibernate.shop.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.hibernate.shop.dao.PromoCodeDao;
import ru.spring.hibernate.shop.entity.PromoCode;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class PromoCodeDaoImpl implements PromoCodeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PromoCode getPromoCode(String promoCodeId) {
        return entityManager.find(PromoCode.class, promoCodeId);
    }

    @Override
    @Transactional
    public void createPromoCode(PromoCode promoCode) {
        entityManager.persist(promoCode);
    }
}
