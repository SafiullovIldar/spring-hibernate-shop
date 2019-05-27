package ru.spring.hibernate.shop.dto;

import lombok.Data;

@Data
public class CustomerDto {

    private String id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
}
