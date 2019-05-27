package ru.spring.hibernate.shop.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.spring.hibernate.shop.dao.PurchaseDao;
import ru.spring.hibernate.shop.dto.ItemDto;
import ru.spring.hibernate.shop.dto.PromoCodeDto;
import ru.spring.hibernate.shop.dto.PurchaseDto;
import ru.spring.hibernate.shop.dto.ShoppingCartDto;
import ru.spring.hibernate.shop.entity.Purchase;
import ru.spring.hibernate.shop.entity.ShoppingCart;
import ru.spring.hibernate.shop.service.ItemService;
import ru.spring.hibernate.shop.service.OrderService;
import ru.spring.hibernate.shop.service.PromoCodeService;
import ru.spring.hibernate.shop.service.ShoppingCartService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private PurchaseDao purchaseDao;
    private ItemService itemService;
    private ConversionService conversion;
    private ShoppingCartService shoppingCartService;
    private PromoCodeService promoCodeService;

    @Override
    public void createPurchase(String customerId,
                               String itemId,
                               Integer amount,
                               String catalogId,
                               String promoCodeId) {

        Purchase purchase = new Purchase();
        purchase.setId(UUID.randomUUID().toString());

        purchase.setAmount(amount);
        purchase.setCreateDate(new Date());

        PromoCodeDto promoCodeDto = promoCodeService.getPromoCode(promoCodeId);
        if (promoCodeDto != null) {
            purchase.setPromoCodeId(promoCodeId);
        } else {
            log.info("There is no such a promoCode");
        }

        ItemDto itemDto = itemService.getItemById(catalogId, itemId);
        purchase.setItemId(itemDto.getId());

        ShoppingCartDto shoppingCartDtoById = shoppingCartService.getShoppingCartDtoById(customerId);
        purchase.setShoppingCart(conversion.convert(shoppingCartDtoById, ShoppingCart.class));

        purchaseDao.createPurchase(purchase);

    }

    @Override
    public List<PurchaseDto> getPurchases(String customerId) {
        List<Purchase> purchases = purchaseDao.getPurchases(customerId);
        List<PurchaseDto> purchaseDtos = new ArrayList<>();

        for (Purchase purchase : purchases) {
            purchaseDtos.add(conversion.convert(purchase, PurchaseDto.class));
        }

        return purchaseDtos;
    }

    @Override
    public PurchaseDto getPurchaseById(String customerId, String purchaseId) {
        Purchase purchaseById = purchaseDao.getPurchaseById(customerId, purchaseId);
        return conversion.convert(purchaseById, PurchaseDto.class);
    }

    @Override
    public List<PurchaseDto> getPurchaseHistory(String customerId) {
        List<Purchase> purchaseHistory = purchaseDao.getPurchaseHistory(customerId);
        List<PurchaseDto> purchaseDtos = new ArrayList<>();


        for (Purchase purchase : purchaseHistory) {
            purchaseDtos.add(conversion.convert(purchase, PurchaseDto.class));
        }

        return purchaseDtos;
    }
}
