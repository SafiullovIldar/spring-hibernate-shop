package ru.spring.hibernate.shop.util;

import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.*;
import ru.spring.hibernate.shop.entity.Item;
import ru.spring.hibernate.shop.enums.PurchaseStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Util {

    public static CreditCardDto createTestCreditCard(String creditCardId) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse ("2019-12-31");
        CreditCardDto creditCard = new CreditCardDto();

        creditCard.setId(creditCardId);
        creditCard.setCardNumber("12345");
        creditCard.setCvsNumber(555L);
        creditCard.setExpirationDate(date);

        return creditCard;
    }

    public static List<PurchaseDto> createTestPurchases() throws ParseException {
        List<PurchaseDto> purchases = new ArrayList<>();

        PurchaseDto purchase1 = createTestPurchase("1");
        PurchaseDto purchase2 = createTestPurchase("2");

        purchases.add(purchase1);
        purchases.add(purchase2);

        return purchases;
    }

    public static PurchaseDto createTestPurchase(String purchaseId) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse ("2019-12-31");

        PurchaseDto dto = new PurchaseDto();
        dto.setId(purchaseId);
        dto.setPromoCodeId("1");
        dto.setItemId("1");
        dto.setStatus(PurchaseStatus.INIT);
        dto.setAmount(5);
        dto.setCreateDate(date);

        return dto;
    }

    public static ShoppingCartDto createTestShoppingCart(String shoppingCartId) throws ParseException {
        ShoppingCartDto dto = new ShoppingCartDto();

        dto.setId(shoppingCartId);
        dto.setPurchases(createTestPurchases());

        return dto;
    }

    public static PromoCodeDto createTestPromoCode(String promoCodeId) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse ("2019-12-31");

        PromoCodeDto dto = new PromoCodeDto();
        dto.setId(promoCodeId);
        dto.setExpirationDate(date);
        dto.setDiscount(10f);

        return dto;
    }

    public static CustomerDto createTestCustomer(String customerId) {
        CustomerDto dto = new CustomerDto();

        dto.setId(customerId);
        dto.setName("TestCustomer");
        dto.setPhoneNumber("TestNumber");
        dto.setEmail("TestEmail");
        dto.setAddress("TestAddress");

        return dto;
    }

    public static ItemDto createTestDtoItem(String itemId) {
        ItemDto item = new ItemDto();

        item.setId(itemId);
        item.setPrice(150);
        item.setAvailability(50);
        item.setName("Test1");

        return item;
    }

    public static Item createTestItem(String itemId) {
        Item item = new Item();

        item.setId(itemId);
        item.setPrice(150);
        item.setAvailability(50);
        item.setName("Test1");

        return item;
    }

    public static List<Item> createTestItems(String firstItemId, String secondItemId) {
        List<Item> items = new ArrayList<>();

        Item item1 = createTestItem(firstItemId);
        Item item2 = createTestItem(secondItemId);

        items.add(item1);
        items.add(item2);

        return items;
    }
}
