package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/users")
public class UserController {
    @GetMapping()
    public List<UserDto> getUsers() {
        return Arrays.asList(new UserDto(1L, "marcin_kowalski2", true, 12345L), new UserDto(2L, "marcin_nowak", true, 12346L));
    }
    @GetMapping(value = "{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return new UserDto(1L, "marcin_kowalski2", true, 12345L);
    }
    @DeleteMapping(value = "{userId}")
    public void deleteUser(@PathVariable Long userId) {
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return new UserDto(1L, "marcin_kowalski2", true, 12345L);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
    }
}