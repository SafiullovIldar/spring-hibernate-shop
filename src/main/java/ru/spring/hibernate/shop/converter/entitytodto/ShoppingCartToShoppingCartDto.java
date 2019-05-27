package ru.spring.hibernate.shop.converter.entitytodto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.PurchaseDto;
import ru.spring.hibernate.shop.dto.ShoppingCartDto;
import ru.spring.hibernate.shop.entity.Purchase;
import ru.spring.hibernate.shop.entity.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingCartToShoppingCartDto implements Converter<ShoppingCart, ShoppingCartDto> {

    @Override
    public ShoppingCartDto convert(ShoppingCart shoppingCart) {
        PurchaseToPurchaseDto toPurchaseDto = new PurchaseToPurchaseDto();
        ShoppingCartDto dto = new ShoppingCartDto();
        List<PurchaseDto> purchaseDtos = new ArrayList<>();
        List<Purchase> purchases = shoppingCart.getPurchases();

        if (purchases != null) {
            for (Purchase purchase : purchases) {
                purchaseDtos.add(toPurchaseDto.convert(purchase));
            }
        }

        dto.setId(shoppingCart.getId());
        dto.setPurchases(purchaseDtos);
        return dto;
    }
}
