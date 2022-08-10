package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.dto.GroupDto;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupMapper {
    @Autowired
    ProductRepository productRepository;

    public Group mapToGroup(GroupDto groupDto) {
        return new Group(
                groupDto.getGroupId(),
                groupDto.getName(),
                Optional.ofNullable(
                        productRepository.findAllById(groupDto.getProductsId())).orElse(Collections.emptyList())
        );
    }

    public GroupDto mapToGroupDto(Group group) {
        return new GroupDto(
                group.getId(),
                group.getName(),
                group.getProducts().isEmpty()? Collections.emptyList() : group.getProducts().stream()
                        .map(product -> product.getId())
                        .collect(Collectors.toList())
        );
    }

    public List<GroupDto> mapToGroupDtoList(List<Group> groups) {
        return groups.isEmpty()? Collections.emptyList() : groups.stream()
                .map(this::mapToGroupDto)
                .collect(Collectors.toList());
    }
}
