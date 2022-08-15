package com.kodilla.ecommercee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class UserDto {

    private Long userId;
    private String username;
    private String password;
    private Boolean status;
    private String userKey;
    private Long cartId;

}
