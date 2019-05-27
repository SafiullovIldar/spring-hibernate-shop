package ru.spring.hibernate.shop.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.spring.hibernate.shop.dao.PurchaseDao;
import ru.spring.hibernate.shop.dao.ShoppingCartDao;
import ru.spring.hibernate.shop.dto.ItemDto;
import ru.spring.hibernate.shop.dto.PurchaseDto;
import ru.spring.hibernate.shop.dto.ShoppingCartDto;
import ru.spring.hibernate.shop.entity.Purchase;
import ru.spring.hibernate.shop.entity.ShoppingCart;
import ru.spring.hibernate.shop.enums.PurchaseStatus;
import ru.spring.hibernate.shop.payment.CreditCardStrategy;
import ru.spring.hibernate.shop.payment.PayPalStrategy;
import ru.spring.hibernate.shop.payment.PaymentStrategy;
import ru.spring.hibernate.shop.service.ItemService;
import ru.spring.hibernate.shop.service.ShoppingCartService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private ShoppingCartDao shoppingCartDao;
    private ConversionService conversion;
    private PurchaseDao purchaseDao;
    private ItemService itemService;

    @Override
    public ShoppingCartDto getShoppingCartDtoById(String customerId) {
        ShoppingCart shoppingCart = shoppingCartDao.getShoppingCartById(customerId);
        ShoppingCartDto shoppingCartDto = conversion.convert(shoppingCart, ShoppingCartDto.class);

        List<Purchase> purchases = purchaseDao.getPurchases(customerId);
        List<PurchaseDto> purchaseDtos = new ArrayList<>();

        if (purchases.size() != 0) {
            for (Purchase purchase : purchases) {
                purchaseDtos.add(conversion.convert(purchase, PurchaseDto.class));
            }

            shoppingCartDto.setPurchases(purchaseDtos);
        }

        return shoppingCartDto;
    }

    @Override
    public void createShoppingCart(ShoppingCartDto dto, String customerId) {
        ShoppingCart shoppingCart = conversion.convert(dto, ShoppingCart.class);
        if (dto.getId() == null) {
            shoppingCart.setId(UUID.randomUUID().toString());
        }

        shoppingCartDao.createShoppingCart(shoppingCart, customerId );
    }

    @Override
    public void pay(String customerId, String paymentMethod) {
        PaymentStrategy paymentStrategy = null;

        List<Purchase> purchases = purchaseDao.getPurchases(customerId);
        int amount = 0;

        for (Purchase purchase : purchases) {
            String itemId = purchase.getItemId();
            ItemDto item = itemService.getItemById(itemId);
            Integer price = item.getPrice();

            if (item.getAvailability() < purchase.getAmount()) {
                log.error("There is not enough availability for " + item.getName());
                continue;
            }

            amount += price * purchase.getAmount();

            item.setAvailability(item.getAvailability() - purchase.getAmount());
            purchase.setStatus(PurchaseStatus.COMPLETED);
        }

        if (paymentMethod.equals("1")){
            paymentStrategy = new CreditCardStrategy();
            paymentStrategy.pay(amount);
        } else if (paymentMethod.equals("2")){
            paymentStrategy = new PayPalStrategy();
            paymentStrategy.pay(amount);
        } else {
            System.out.println("There is no payment information");
        }
    }
}
