package com.kodilla.ecommercee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private Long userId;
    private Long cartId;
    private LocalDateTime orderDate;
    private String execution;
    private List<Long> productsId;
}
