package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.CartDto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/carts")
public class CartController {

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

    @GetMapping(value = "{cartId}")
    public CartDto getCart(@PathVariable Long cartId) {
        return new CartDto(1L);
    }

    @DeleteMapping
    public void deleteCart(@PathVariable Long taskId) {
        System.out.println("Delete test");
    }

    @PutMapping
    public CartDto editCart(@RequestBody CartDto cartDto) {
        return new CartDto(1L);
    }

    @PostMapping
    public void addOrderToCart(@RequestBody CartDto cartDto) {
        System.out.println("Test add order to cart");
    }

}
