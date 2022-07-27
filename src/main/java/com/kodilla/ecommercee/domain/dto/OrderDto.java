package com.kodilla.ecommercee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private LocalDate dateOrder;
    private String ExecutionOrder;

}
