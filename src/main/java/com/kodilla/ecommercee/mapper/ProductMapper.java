package com.kodilla.ecommercee.mapper;
import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.repository.GroupRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductMapper {

    private GroupRepository groupRepository;

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(
                productDto.getName(),
                productDto.getPrice(),
                productDto.isAvailable(),
                groupRepository.findById(productDto.getGroupId())
                        .orElseThrow(() -> new RuntimeException("Group id '" + productDto.getGroupId() +
                                "' doesn't exist"))
        );
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.isAvailability(),
                product.getPrice(),
                product.getGroup().getId(),
                product.getOrders().isEmpty()? Collections.emptyList() : product.getOrders().stream()
                        .map(Order::getId)
                        .collect(Collectors.toList()),
                product.getCarts().isEmpty()? Collections.emptyList() : product.getCarts().stream()
                        .map(Cart::getId)
                        .collect(Collectors.toList())
        );
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.isEmpty()? Collections.emptyList() : productList.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }

}
