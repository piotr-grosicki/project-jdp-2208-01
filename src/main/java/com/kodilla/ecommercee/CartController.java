package com.kodilla.ecommercee;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/v1/carts")
public class CartController {

    @PostMapping(value = "create")
    public void createCart() {
        System.out.println("Create new cart");
    }

    @GetMapping
    public List<String> getAllCarts() {
        List<String> cart = new ArrayList<>();
        cart.add("element1");
        cart.add("element2");
        cart.add("element3");
        cart.add("element4");
        cart.add("element5");
        return cart;
    }

    @PutMapping(value = "update")
    public void updateCart() {
        System.out.println("Add new elements");
    }

    @DeleteMapping(value = "delete")
    public void deleteCart() {
        System.out.println("Delayed product");
    }

    @PostMapping(value = "createOrder")
    public void createOrderFromCard() {
        System.out.println("Create new order from card");
    }
}
