package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserData;
import com.kodilla.ecommercee.domain.dto.UserDto;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.DbUserServices;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/v1/users")
public class UserController {


    private UserMapper userMapper;
    private DbUserServices userServices;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto){
        User user = userMapper.mapToUser(userDto);
        userServices.createUser(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "block/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void blockUser(@RequestBody UserData userData, @PathVariable Long id) throws UserNotFoundException {
        userServices.blockUser(userData, id);
    }

    @PutMapping(value = "unlock/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void unlockUser(@RequestBody UserData userData, @PathVariable Long id) throws UserNotFoundException {
        userServices.unlockUser(userData, id);
    }

}
