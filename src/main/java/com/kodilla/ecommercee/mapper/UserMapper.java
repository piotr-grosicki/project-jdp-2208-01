package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User mapToUser(UserDto userDto){
        return User.builder()
                .id(userDto.getUserId())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .content(userDto.getStatus())
                .userKey(userDto.getUserKey())
                .build();
    }

    public UserDto mapToUserDto(final User user) {
        return UserDto.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .status(user.getContent())
                .userKey(user.getUserKey())
                .cartId(user.getCart().getId())
                .build();
    }
}
