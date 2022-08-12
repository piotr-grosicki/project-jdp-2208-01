package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbProductService {

    private ProductRepository productRepository;

    public Product getProduct(final Long id) {
        return productRepository.findById(id).orElseThrow( () -> new ProductNotFoundException("Product of id: '" + id +
                "' not found."));
    }

    public Product saveProduct(final Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) { productRepository.deleteById(id); }

    public List<Product> getAllProducts() { return productRepository.findAll(); }
}