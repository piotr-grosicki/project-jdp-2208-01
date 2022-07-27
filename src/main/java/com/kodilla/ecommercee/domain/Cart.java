package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id", unique = true)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "status")
    private Boolean content;

    @Column(name = "userkey")
    private Long userKey;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
    private Cart cart;

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private final List<Order> orders = new ArrayList<>();
}