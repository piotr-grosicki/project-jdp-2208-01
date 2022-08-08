package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
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

    public User(String username, Boolean content, Long userKey) {
        this.username = username;
        this.content = content;
        this.userKey = userKey;
    }
}