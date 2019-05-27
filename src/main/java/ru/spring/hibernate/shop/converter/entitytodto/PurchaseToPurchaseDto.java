package ru.spring.hibernate.shop.converter.entitytodto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.PurchaseDto;
import ru.spring.hibernate.shop.entity.Purchase;

@Component
public class PurchaseToPurchaseDto implements Converter<Purchase, PurchaseDto> {

    @Override
    public PurchaseDto convert(Purchase purchase) {

        PurchaseDto dto = new PurchaseDto();
        dto.setId(purchase.getId());
        dto.setAmount(purchase.getAmount());
        dto.setCreateDate(purchase.getCreateDate());
        dto.setStatus(purchase.getStatus());
        dto.setItemId(purchase.getItemId());
        dto.setPromoCodeId(purchase.getPromoCodeId());
        if (purchase.getShoppingCart() != null) {
            dto.setShoppingCart(purchase.getShoppingCart());
        }
        return dto;
    }
}
