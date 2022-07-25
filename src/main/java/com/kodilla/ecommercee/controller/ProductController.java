package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @GetMapping(value = "list")
    public List<ProductDto> getAllProducts() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{id}")
    public ProductDto getOneProducts(@PathVariable Long id) {
        return new ProductDto();
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
       return new ProductDto();
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductDto productDto) {

    }

    @DeleteMapping(value = "{id}")
    public void deleteProduct(@PathVariable Long id) {

    }
}
