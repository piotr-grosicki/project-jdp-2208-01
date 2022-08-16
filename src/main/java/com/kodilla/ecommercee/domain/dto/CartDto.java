package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class CartDto {

    private final Long id;
    private final Long userId;
    private final List<Long> products;

}


