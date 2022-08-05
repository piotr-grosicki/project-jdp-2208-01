package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductDbService {

    private ProductRepository productRepository;

    public Product getProduct(final Long id) {
        return productRepository.findById(id).get();
    }

    public Product saveProduct(final Product product) {
        return productRepository.save(product);
    }
}