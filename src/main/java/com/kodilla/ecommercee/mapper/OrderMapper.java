package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.OrderDto;

import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderMapper {

    ProductRepository productRepository;

    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                orderDto.getOrderDate(),
                orderDto.getExecution(),
                Optional.ofNullable(
                        productRepository.findAllById(orderDto.getProductsId())).orElse(Collections.emptyList())
        );
    }

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(
                order.getId(),
                order.getUser().getId(),
                order.getCart().getId(),
                order.getOrderDate(),
                order.getExecution(),
                order.getProducts().isEmpty()? Collections.emptyList() : order.getProducts().stream()
                        .map(Product::getId)
                        .collect(Collectors.toList())
        );
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
    }
}
