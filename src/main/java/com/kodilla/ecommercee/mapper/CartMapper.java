package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartMapper {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Cart mapToCart(final @NotNull CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                Optional.ofNullable(productRepository.findAllById(cartDto.getProducts())).orElse(Collections.emptyList()),
                userRepository.findById(cartDto.getUserId())
                        .orElseThrow(() -> new RuntimeException("User id '" + cartDto.getUserId() +
                                "' doesn't exist"))
        );
    }

    public CartDto mapToCartDto(final @NotNull Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getUser().getId(),
                cart.getProducts().isEmpty()? Collections.emptyList() : cart.getProducts().stream()
                        .map(Product::getId).collect(Collectors.toList()));
    }

}
