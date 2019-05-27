package ru.spring.hibernate.shop.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.hibernate.shop.dao.ShoppingCartDao;
import ru.spring.hibernate.shop.entity.ShoppingCart;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ShoppingCartDaoImpl implements ShoppingCartDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ShoppingCart getShoppingCartById(String customerId) {
        return entityManager.find(ShoppingCart.class, customerId);
    }

    @Override
    @Transactional
    public void createShoppingCart(ShoppingCart shoppingCart, String customerId){

        entityManager.createNativeQuery("INSERT INTO shopping_cart VALUES (?, ?)")
                .setParameter(1, shoppingCart.getId())
                .setParameter(2, customerId)
                .executeUpdate();
    }
}
