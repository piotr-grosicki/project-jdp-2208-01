package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id", unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column(name = "date")
    private LocalDateTime orderDate;

    @Column(name = "execution")
    private String execution;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "orders")
    private List<Product> products = new ArrayList<>();

    public Order(User user, Cart cart, LocalDateTime orderDate, String execution, List<Product> products) {
        this.user = user;
        this.cart = cart;
        this.orderDate = orderDate;
        this.execution = execution;
        this.products = products;
    }
}
