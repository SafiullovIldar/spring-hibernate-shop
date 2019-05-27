package ru.spring.hibernate.shop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class ShoppingCart {

    @Id
    private String id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "shoppingCart")
    private List<Purchase> purchases;
}
