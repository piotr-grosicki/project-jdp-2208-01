package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
public class Order {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "order_id", unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
}
