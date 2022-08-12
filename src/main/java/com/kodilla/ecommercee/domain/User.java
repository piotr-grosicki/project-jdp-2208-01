package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @NonNull
    @GeneratedValue
    @Column(name = "user_id", unique = true)
    private Long id;

    @NonNull
    @Column(name = "username")
    private String username;

    @NonNull
    @Column(name = "password")
    private String password;

    @NonNull
    @Column(name = "status")
    private Boolean content;

    @Column(name = "userkey")
    private Long userKey;

    @Column(name = "KeyStartTime")
    private LocalDateTime keyStartTime;

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

    public User(@NonNull String username, @NonNull Boolean content) {
        this.username = username;
        this.content = content;
    }
}