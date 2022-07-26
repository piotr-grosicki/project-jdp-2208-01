package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
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

    @ManyToOne()
    @JoinColumns({
            @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
    })
    private User user;

    @Column(name = "date")
    private LocalDateTime orderDate;

    @Column(name = "execution")
    private String execution;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private List<Product> products;
}
