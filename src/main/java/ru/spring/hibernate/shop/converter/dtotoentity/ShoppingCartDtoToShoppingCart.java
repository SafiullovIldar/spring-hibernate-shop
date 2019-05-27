package ru.spring.hibernate.shop.converter.dtotoentity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.ShoppingCartDto;
import ru.spring.hibernate.shop.entity.ShoppingCart;

@Component
public class ShoppingCartDtoToShoppingCart implements Converter<ShoppingCartDto, ShoppingCart> {

    @Override
    public ShoppingCart convert(ShoppingCartDto shoppingCartDto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(shoppingCartDto.getId());
        return shoppingCart;
    }
}
