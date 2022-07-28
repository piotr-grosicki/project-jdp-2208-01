package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "products")
public class Product {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "product_id", unique = true)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_orders",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "order_id")}
    )
    private List<Order> orders = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    private Group group;

}

