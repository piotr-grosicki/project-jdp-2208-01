package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.dto.CartNotFoundException;
import com.kodilla.ecommercee.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbCartService {

    private final CartRepository repository;

    public List<Cart> getAllCarts() {
        return repository.findAll();
    }

    public Cart getCart(final Long cartId) throws CartNotFoundException {
        return repository.findById(cartId).orElseThrow(CartNotFoundException::new);
    }

    public Cart saveCart(final Cart cart) {
        return repository.save(cart);
    }

}
