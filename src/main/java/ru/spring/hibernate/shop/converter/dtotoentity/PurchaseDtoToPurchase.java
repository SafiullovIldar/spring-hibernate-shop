package ru.spring.hibernate.shop.converter.dtotoentity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.PurchaseDto;
import ru.spring.hibernate.shop.entity.Purchase;

@Component
public class PurchaseDtoToPurchase implements Converter<PurchaseDto, Purchase> {

    @Override
    public Purchase convert(PurchaseDto purchaseDto) {

        Purchase purchase = new Purchase();
        purchase.setId(purchaseDto.getId());
        purchase.setStatus(purchaseDto.getStatus());
        purchase.setAmount(purchaseDto.getAmount());
        purchase.setCreateDate(purchaseDto.getCreateDate());
        purchase.setItemId(purchaseDto.getItemId());
        purchase.setPromoCodeId(purchaseDto.getPromoCodeId());
        if (purchaseDto.getShoppingCart() != null) {
            purchase.setShoppingCart(purchaseDto.getShoppingCart());
        }


        return purchase;
    }
}
