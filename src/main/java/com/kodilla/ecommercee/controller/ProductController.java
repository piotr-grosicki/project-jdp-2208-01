package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private ProductDbService productDbService;
    private ProductMapper productMapper;
    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productMapper.mapToProductDtoList(productDbService.getAllProducts());
    }

    @GetMapping(value = "{id}")
    public ProductDto getOneProducts(@PathVariable Long id) {
        return productMapper.mapToProductDto(productDbService.getProduct(id));
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductDto productDto) {
       return productDbService.saveProduct(productMapper.mapToProduct(productDto));
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productMapper.mapToProductDto(productDbService.saveProduct(productMapper.mapToProduct(productDto)));
    }

    @DeleteMapping(value = "{id}")
    public void deleteProduct(@PathVariable Long id) {
        productDbService.deleteProduct(id);
    }
}
