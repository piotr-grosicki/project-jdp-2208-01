package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserData;
import com.kodilla.ecommercee.domain.dto.UserDto;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.DbUserKeyService;
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
    private DbUserKeyService userKeyService;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto){
        User user = userMapper.mapToUser(userDto);
        userServices.createUser(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "login/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void login(@RequestBody UserData userData, @PathVariable Long id) throws UserNotFoundException {
        Boolean isCorrect = userKeyService.checkUser(userData, id);
        if (isCorrect.equals(true)){
            String generatedKey = userKeyService.generateUserKey();
            userServices.updateUserKey(id, generatedKey);
        } else {
            System.out.println("Wrong username or password");
        }
    }

    @PutMapping(value = "block/{id}")
    public void blockUser(@RequestBody String key, @PathVariable Long id) throws UserNotFoundException {
        userServices.blockUser(id, key);
    }
}
