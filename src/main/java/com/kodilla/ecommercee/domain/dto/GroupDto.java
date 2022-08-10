package com.kodilla.ecommercee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GroupDto {

    private Long groupId;
    private String name;
    private List<Long> productsId;
}
