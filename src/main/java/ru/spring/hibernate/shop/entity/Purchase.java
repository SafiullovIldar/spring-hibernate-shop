package ru.spring.hibernate.shop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spring.hibernate.shop.enums.PurchaseStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Purchase {

    @Id
    private String id;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "status")
    private PurchaseStatus status = PurchaseStatus.INIT;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "item_id")
    private String itemId;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private ShoppingCart shoppingCart;

    @Column(name = "promo_id")
    private String promoCodeId;

}
