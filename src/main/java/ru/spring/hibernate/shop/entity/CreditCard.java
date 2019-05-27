package ru.spring.hibernate.shop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "credit_card")
public class CreditCard {

    @Id
    private String id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "cvc")
    private Long cvsNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
