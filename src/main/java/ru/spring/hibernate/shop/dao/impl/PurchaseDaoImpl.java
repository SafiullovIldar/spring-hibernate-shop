package ru.spring.hibernate.shop.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.hibernate.shop.dao.PurchaseDao;
import ru.spring.hibernate.shop.entity.Purchase;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static ru.spring.hibernate.shop.enums.PurchaseStatus.COMPLETED;
import static ru.spring.hibernate.shop.enums.PurchaseStatus.INIT;

@Component
public class PurchaseDaoImpl implements PurchaseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createPurchase(Purchase purchase) {
        entityManager.persist(purchase);
    }

    @Override
    public Purchase getPurchaseById(String customerId, String purchaseId) {
        return (Purchase) entityManager.createNativeQuery( "SELECT p.*" +
                "  FROM purchase p," +
                "       shopping_cart sc," +
                "       customer c" +
                " WHERE p.id = ?" +
                "   AND p.cart_id = sc.id" +
                "   AND sc.customer_id = c.id" +
                "   AND c.id = ?;")
                .setParameter(1, purchaseId)
                .setParameter(2, customerId)
                .getSingleResult();
    }

    @Override
    public List<Purchase> getPurchases(String customerId) {

        return entityManager.createNativeQuery("SELECT p.*" +
                "  FROM purchase p," +
                "       shopping_cart sc," +
                "       customer c" +
                " WHERE p.cart_id = sc.id" +
                "   AND sc.customer_id = c.id" +
                "   AND c.id = ?" +
                "   AND p.status = ?;")
                .setParameter(1, customerId)
                .setParameter(2, INIT)
                .getResultList();
    }

    @Override
    public List<Purchase> getPurchaseHistory(String customerId) {
        return entityManager.createNativeQuery("SELECT p.*" +
                "  FROM purchase p," +
                "       shopping_cart sc," +
                "       customer c" +
                " WHERE p.cart_id = sc.id" +
                "   AND sc.customer_id = c.id" +
                "   AND c.id = ?" +
                "   AND p.status = ?;")
                .setParameter(1, customerId)
                .setParameter(2, COMPLETED)
                .getResultList();
    }
}
