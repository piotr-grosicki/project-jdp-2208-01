package com.kodilla.ecommercee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private boolean isAvailable;
    private BigDecimal price;
    private Long groupId;
    private List<Long> ordersId;
    private List<Long> cartsId;

}
