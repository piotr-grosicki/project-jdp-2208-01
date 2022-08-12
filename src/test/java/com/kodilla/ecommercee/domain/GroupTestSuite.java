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

@Test
    public void testRelationsWithProducts() {
        //Given
        Group group = new Group("name of group");
        Product product1 = new Product("product1", new BigDecimal(100.20), true, group);
        Product product2 = new Product("product2", new BigDecimal(40.00), true, group);
        List<Product> products = Arrays.asList(product1, product2);

        //When
        group.getProducts().add(product1);
        group.getProducts().add(product2);
        List<Product> productsFromGroup = group.getProducts();

        groupRepository.save(group);
        productRepository.save(product1);
        productRepository.save(product2);

        //Then
        Assert.assertEquals(2, productsFromGroup.size());
        Assert.assertEquals(2, products.size());
        Assert.assertEquals(products, productsFromGroup);

    }
}
