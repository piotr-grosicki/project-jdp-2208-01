package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @GetMapping
    public List<OrderDto> getOrders() {
        List<OrderDto> orders = new ArrayList<>();
        orders.add(new OrderDto(2L, LocalDate.of(2022, 06, 04), "done"));
        orders.add(new OrderDto(3L, LocalDate.of(2022, 07, 25), "shipping"));
        return orders;
    }

    @PostMapping
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(1L, LocalDate.of(2022, 05, 05), "in progress");
    }

    @GetMapping("/{id}")
    public OrderDto getOrder(@PathVariable Long id) {
        return new OrderDto(1L, LocalDate.of(2022, 05, 05), "in progress" );
    }

    @PutMapping
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(1L, LocalDate.of(2022, 05, 05 ), "done");
    }

    @DeleteMapping(value = "{id}")
    public void deleteOrder(@PathVariable Long id) {
        System.out.println("delete testing done!");
    }
}