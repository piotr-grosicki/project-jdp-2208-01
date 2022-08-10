package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.GroupDto;
import com.kodilla.ecommercee.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.DbGroupService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/group")
public class GroupController {

    @Autowired
    private final GroupMapper groupMapper;

    @Autowired
    private final DbGroupService dbGroupService;

    @GetMapping
    public List<GroupDto> getAllGroups() {
        return groupMapper.mapToGroupDtoList(dbGroupService.getGroups());
    }

    @PostMapping
    public void createGroup(@RequestBody GroupDto groupDto) {
        dbGroupService.saveGroup(groupMapper.mapToGroup(groupDto));
    }

    @GetMapping(value = "{id}")
    public GroupDto getById(@PathVariable Long id) throws GroupNotFoundException {
        return groupMapper.mapToGroupDto(dbGroupService.getGroup(id));
    }

    @PutMapping
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return groupMapper.mapToGroupDto(dbGroupService.saveGroup(groupMapper.mapToGroup(groupDto)));
    }

    @DeleteMapping(value = "{id}")
    public void deleteGroup(@PathVariable Long id) {
        dbGroupService.deleteGroup(id);
    }
}