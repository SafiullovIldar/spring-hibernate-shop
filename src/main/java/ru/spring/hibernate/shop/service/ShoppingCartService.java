package ru.spring.hibernate.shop.service;

import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.ShoppingCartDto;

@Component
public interface ShoppingCartService {

    ShoppingCartDto getShoppingCartDtoById(String customerId);
    void createShoppingCart(ShoppingCartDto dto, String customerId);
    void pay(String customerId, String paymentMethod);
}
