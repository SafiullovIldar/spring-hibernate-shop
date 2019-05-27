package ru.spring.hibernate.shop.dto;

import lombok.Data;
import ru.spring.hibernate.shop.entity.ShoppingCart;
import ru.spring.hibernate.shop.enums.PurchaseStatus;

import java.util.Date;

@Data
public class PurchaseDto {

    private String id;
    private Date createDate;
    private PurchaseStatus status = PurchaseStatus.INIT;
    private Integer amount;
    private String itemId;
    private ShoppingCart shoppingCart;
    private String promoCodeId;
}
