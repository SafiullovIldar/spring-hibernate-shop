package ru.spring.hibernate.shop.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "promo_code")
public class  PromoCode {

    @Id
    private String id;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "discount")
    private Float discount;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
