package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DbProductService {

    private final ProductRepository repository;

    public Product getProduct(final Long productId) throws CartNotFoundException {
        return repository.findById(productId).orElseThrow(CartNotFoundException::new);
    }
}
