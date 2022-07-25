package com.kodilla.ecommercee.domain.dto;

public class UserDto {
    private Long userId;
    private String firstName;
    private String lastName;

    public UserDto(Long userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
