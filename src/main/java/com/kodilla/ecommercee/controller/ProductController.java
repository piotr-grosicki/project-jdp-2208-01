package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.DbProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
@AllArgsConstructor
public class ProductController {

    private DbProductService dbProductService;
    private ProductMapper productMapper;
    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productMapper.mapToProductDtoList(dbProductService.getAllProducts());
    }

    @GetMapping(value = "{id}")
    public ProductDto getOneProducts(@PathVariable Long id) {
        return productMapper.mapToProductDto(dbProductService.getProduct(id));
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductDto productDto) {
       return dbProductService.saveProduct(productMapper.mapToProduct(productDto));
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productMapper.mapToProductDto(dbProductService.saveProduct(productMapper.mapToProduct(productDto)));
    }

    @DeleteMapping(value = "{id}")
    public void deleteProduct(@PathVariable Long id) {
        dbProductService.deleteProduct(id);
    }
}
