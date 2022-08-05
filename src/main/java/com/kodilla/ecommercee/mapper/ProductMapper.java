package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductMapper {

    private OrderRepository orderRepository;
    private CartRepository cartRepository;
    private GroupRepository groupRepository;

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(
                productDto.getName(),
                productDto.getPrice(),
                productDto.isAvailable(),
                groupRepository.findById(productDto.getGroupId())
                        .orElseThrow(() -> new RuntimeException("Group id '" + productDto.getGroupId() +
                                "' doens't exist"))
        );
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.isAvailability(),
                product.getPrice(),
                product.getGroup().getId(),
                product.getOrders().stream()
                        .map(Order::getId)
                        .collect(Collectors.toList()),
                product.getCarts().stream()
                        .map(Cart::getId)
                        .collect(Collectors.toList())
        );
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }
}
