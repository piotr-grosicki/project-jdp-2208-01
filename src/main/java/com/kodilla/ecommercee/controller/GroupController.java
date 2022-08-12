package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.GroupDto;
import com.kodilla.ecommercee.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.DbGroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/group")
public class GroupController {


    private final GroupMapper groupMapper;

    private final DbGroupService dbGroupService;

    @GetMapping
    public ResponseEntity<List<GroupDto>> getAllGroups() {
        return ResponseEntity.ok(groupMapper.mapToGroupDtoList(dbGroupService.getGroups()));
    }

    @PostMapping
    public ResponseEntity<Void> createGroup(@RequestBody GroupDto groupDto) {
        dbGroupService.saveGroup(groupMapper.mapToGroup(groupDto));
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<GroupDto> getById(@PathVariable Long id) throws GroupNotFoundException {
        return ResponseEntity.ok(groupMapper.mapToGroupDto(dbGroupService.getGroup(id)));
    }

    @PutMapping
    public ResponseEntity<GroupDto> updateGroup(@RequestBody GroupDto groupDto) {
        return ResponseEntity.ok(groupMapper.mapToGroupDto(dbGroupService.saveGroup(groupMapper.mapToGroup(groupDto))));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
        dbGroupService.deleteGroup(id);
        return ResponseEntity.ok().build();
    }
}