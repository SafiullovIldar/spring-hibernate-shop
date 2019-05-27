package ru.spring.hibernate.shop.service;

import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.PurchaseDto;

import java.util.List;

@Component
public interface OrderService {

    void createPurchase(String customerId,
                        String itemId,
                        Integer amount,
                        String catalogId,
                        String promoCodeId);
    List<PurchaseDto> getPurchases(String customerId);
    PurchaseDto getPurchaseById(String customerId, String purchaseId);
    List<PurchaseDto> getPurchaseHistory(String customerId);

}
