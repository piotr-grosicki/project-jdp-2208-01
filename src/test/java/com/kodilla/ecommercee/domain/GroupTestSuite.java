package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GroupTestSuite {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void testSaveGroup() {
        //Given
        Group group = new Group("name of group");

        //When
        groupRepository.save(group);
        long id = group.getId();
        Optional<Group> optionalGroup = groupRepository.findById(id);

        //Then
        Assert.assertTrue(optionalGroup.isPresent());
    }

    @Test
    public void testShouldUpdateGroupName() {
        //Given
        Group group = new Group("name of group");
        groupRepository.save(group);

        //When
        group.setName("new name");
        groupRepository.save(group);
        Optional<Group> fetchedGroup = groupRepository.findById(group.getId());

        //Then
        Assert.assertTrue(fetchedGroup.isPresent());
        Assert.assertEquals("new name", fetchedGroup.get().getName());
    }


}
