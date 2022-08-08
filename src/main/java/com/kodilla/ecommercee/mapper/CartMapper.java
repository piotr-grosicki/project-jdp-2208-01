package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.dto.CartDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartMapper {

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                cartDto.getProducts(),
                cartDto.getUser()
        );
    }

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getProducts(),
                cart.getUser()
        );
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> taskList) {
        return taskList.stream()
                .map(this::mapToCartDto)
                .collect(Collectors.toList());
    }
}
