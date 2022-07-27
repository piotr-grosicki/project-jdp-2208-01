package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
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

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "availability")
    private boolean availability;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "products_orders",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "order_id")}
    )
    private List<Order> orders = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private List<Cart> carts = new ArrayList<>();


}
