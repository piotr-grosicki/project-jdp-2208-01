package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.GroupDto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {

    @GetMapping
    public List<GroupDto> getAllGroups() {
        return new ArrayList<>();
    }

    @PostMapping
    public GroupDto createGroup(@RequestBody GroupDto groupDto) {
        return new GroupDto(1L, "ubrania");
    }

    @GetMapping(value = "{id}")
    public GroupDto getById(@PathVariable Long id) {
        return new GroupDto(1L,"ubrania");
    }

    @PutMapping
    public void updateGroup(@RequestBody GroupDto groupDto) {

    }
}