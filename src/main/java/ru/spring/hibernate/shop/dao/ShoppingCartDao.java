package ru.spring.hibernate.shop.dao;

import ru.spring.hibernate.shop.entity.ShoppingCart;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public interface ShoppingCartDao {

    ShoppingCart getShoppingCartById(String shoppingCartId);
    void createShoppingCart(ShoppingCart shoppingCart, String customerId);
}
