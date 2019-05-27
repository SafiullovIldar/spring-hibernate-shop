package ru.spring.hibernate.shop.dto;

import lombok.Data;

import java.util.List;

@Data
public class ShoppingCartDto {

    private String id;
    private List<PurchaseDto> purchases;
}
