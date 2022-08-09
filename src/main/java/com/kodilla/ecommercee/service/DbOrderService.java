package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbOrderService {

    private final OrderRepository orderRepository;

    public Order findOrderById(final Long id) throws OrderNotFoundException {
        return orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Order saveOrder(final Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(final Long id) throws OrderNotFoundException {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        } else {
            throw new OrderNotFoundException();
        }
    }

    public Order updateOrder(final Order order) throws OrderNotFoundException {
        if (orderRepository.existsById(order.getId())) {
            orderRepository.save(order);
            return order;
        } else {
            throw new OrderNotFoundException();
        }
    }
}
