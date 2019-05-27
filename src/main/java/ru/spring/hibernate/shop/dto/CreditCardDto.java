package ru.spring.hibernate.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spring.hibernate.shop.entity.Customer;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDto {

    private String id;
    private String cardNumber;
    private Date expirationDate;
    private Long cvsNumber;
    private Customer customer;
}