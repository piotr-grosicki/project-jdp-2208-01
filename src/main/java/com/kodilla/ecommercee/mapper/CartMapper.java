package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartMapper {

    private final ProductRepository productRepository;

    public Cart mapToCart(final @NotNull CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                Optional.ofNullable(productRepository.findAllById(cartDto.getProducts())).orElse(Collections.emptyList()),
                cartDto.getUserId());

    }

    public CartDto mapToCartDto(final @NotNull Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getUser(),
                cart.getProducts().isEmpty()? Collections.emptyList() : cart.getProducts().stream()
                        .map(Product::getId).collect(Collectors.toList()));
    }

}
