package ru.spring.hibernate.shop.dao;

import ru.spring.hibernate.shop.entity.Purchase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PurchaseDao {

    void createPurchase(Purchase purchase);
    Purchase getPurchaseById(String customerId, String purchaseId);
    List getPurchases(String customerId);
    List<Purchase> getPurchaseHistory(String customerId);

}
