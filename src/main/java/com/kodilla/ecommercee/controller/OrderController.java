package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @GetMapping
    public List<OrderDto> getOrders() {
        return new ArrayList<>();
    }

    @PostMapping
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto();
    }

    @GetMapping("/{id}")
    public OrderDto getOrder(@PathVariable Long id) {
        return new OrderDto();
    }

    @PutMapping
    public void updateOrder(@RequestBody OrderDto orderDto) {

    }

    @DeleteMapping(value = "{id}")
    public void deleteOrder(@PathVariable Long id) {

    }
}