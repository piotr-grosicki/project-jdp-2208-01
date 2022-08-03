package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{id}")
    public ProductDto getOneProducts(@PathVariable Long id) {
        return new ProductDto(1L, "name","range",20L,1L);
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
       return new ProductDto(1L, "name","range",20L,1L);
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductDto productDto) {

    }

    @DeleteMapping(value = "{id}")
    public void deleteProduct(@PathVariable Long id) {

    }
}
