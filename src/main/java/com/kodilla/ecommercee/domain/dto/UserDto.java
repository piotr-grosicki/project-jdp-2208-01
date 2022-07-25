package com.kodilla.ecommercee.domain.dto;

public class UserDto {

    private Long userId;
    private String userName;
    private String userLastName;

    public UserDto(Long userId, String userName, String userLastName) {
        this.userId = userId;
        this.userName = userName;
        this.userLastName = userLastName;
    }
}
