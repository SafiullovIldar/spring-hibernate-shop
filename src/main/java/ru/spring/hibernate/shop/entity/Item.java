package ru.spring.hibernate.shop.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Item {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "availability")
    private Integer availability;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalogId;

    @OneToMany(mappedBy = "item", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PromoCode> promoCodes;
}
