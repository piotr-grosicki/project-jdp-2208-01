package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/v1/users")
public class UserController {
    @GetMapping()
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }
    @GetMapping(value = "{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return new UserDto(1L, "John", "Smith");
    }
    @DeleteMapping(value = "{userId}")
    public void deleteUser(@PathVariable Long userId) {
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return new UserDto(1L, "John", "Smith");
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
    }
}
