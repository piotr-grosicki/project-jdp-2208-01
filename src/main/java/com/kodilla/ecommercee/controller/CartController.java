package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.DbCartService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/carts")
public class CartController {

    ProductController dbProductService;
    ProductMapper productMapper;
    DbCartService dbCartService;
    CartMapper cartMapper;

    @GetMapping
    public ResponseEntity<List<CartDto>> getAllCarts() {
        List<Cart> carts = dbCartService.getAllCarts();
        return ResponseEntity.ok(cartMapper.mapToCartDtoList(carts));
    }

/*    @GetMapping(value = "{cartId}")
    public ResponseEntity<List<ProductDto>> getCart(@PathVariable Long cartId) throws ProductNotFoundException, CartNotFoundException {
        return ResponseEntity.ok(productMapper.mapToProductDtoList(dbCartService.getCart(cartId).getProducts()));
    }

    @DeleteMapping(value = "/{cartId}/remove/{productId}")
    public ResponseEntity<Void> deleteProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) throws CartNotFoundException {
        dbCartService.getCart(cartId).getProducts().remove(dbProductService.getProduct(productId));
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{cartId}/add/{productId}")
    public ResponseEntity<Void> addProductToCart(@PathVariable Long cartId, @RequestBody ProductDto productDto, @PathVariable String productId) throws CartNotFoundException {
        dbCartService.getCart(cartId).getProducts().add(productMapper.mapToProduct(productDto));
        return ResponseEntity.ok().build();
    }*/

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addCart(@RequestBody CartDto cartDto) {
        Cart cart = cartMapper.mapToCart(cartDto);
        dbCartService.saveCart(cart);
        return ResponseEntity.ok().build();
    }
}
