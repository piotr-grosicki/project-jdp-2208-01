package com.kodilla.ecommercee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserDto {

    private Long userId;
    private String username;
    private String password;
    private Boolean status;
    private Long userKey;
    private Long cartId;

}
