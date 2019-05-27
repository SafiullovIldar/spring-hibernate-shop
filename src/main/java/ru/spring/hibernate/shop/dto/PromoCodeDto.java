package ru.spring.hibernate.shop.dto;

import lombok.Data;
import ru.spring.hibernate.shop.entity.Item;

import java.util.Date;

@Data
public class PromoCodeDto {

    private String id;
    private Date expirationDate;
    private Float discount;
    private Item item;
}
