package ru.spring.hibernate.shop.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.hibernate.shop.dao.CreditCardDao;
import ru.spring.hibernate.shop.entity.CreditCard;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class CreditCardDaoImpl implements CreditCardDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createCreditCard(CreditCard creditCard) {
        entityManager.persist(creditCard);
    }

    @Override
    public CreditCard getCreditCard(String creditCardId) {
        return entityManager.find(CreditCard.class, creditCardId);
    }

    @Override
    public CreditCard getCreditCardByCustomerId(String customerId) {
        Query query = entityManager.createQuery("SELECT c FROM CreditCard c WHERE c.customer = " + customerId);
        return (CreditCard) query.getSingleResult();
    }
}
