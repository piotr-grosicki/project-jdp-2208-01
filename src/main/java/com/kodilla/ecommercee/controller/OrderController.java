package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    private List<OrderDto> orders;

    public OrderController() {
        orders = new ArrayList<>();
        orders.add(new OrderDto(3L, LocalDate.of(2021, 12, 12), "done"));
        orders.add(new OrderDto(4L, LocalDate.of(2022, 1, 22), "in progress"));
    }

    @GetMapping
    public List<OrderDto> getOrders() {
        return orders;
    }

    @PostMapping
    public boolean createOrder(@RequestBody OrderDto orderDto) {
        return orders.add(orderDto);
    }

    @GetMapping("/{id}")
    public OrderDto getOrder(@PathVariable Long id) {
        return new OrderDto(1L, LocalDate.of(2022, 05, 05), "in progress");
    }

    @PutMapping
    public OrderDto updateOrder(OrderDto orderDto) {
      return new OrderDto(2L, LocalDate.of(2022, 05, 05), "done");
    }

    @DeleteMapping
    public void deleteOrder(OrderDto orderDto) {

    }
}
