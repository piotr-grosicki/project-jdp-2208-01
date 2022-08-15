package com.kodilla.ecommercee.domain;


import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTestSuite {



    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrderRepository orderRepository;

    User user = new User();
    Cart cart = new Cart();


    @Before
    public void prepareDate() {
        user.setUsername("user1");
        user.setUserKey(1L);
        user.setContent(true);
        user.setCart(cart);
        cart.setUser(user);

    }

    @Test
    public void FindUserByAllFieldsTest() {
        //Given
        //When
        userRepository.save(user);
        //Then

        assertTrue(userRepository.findById(user.getId()).isPresent());
        assertTrue(userRepository.findByUsername(user.getUsername()).isPresent());
        assertTrue(userRepository.findByUserKey(user.getUserKey()).isPresent());
        assertTrue(userRepository.findByContent(user.getContent()).isPresent());

        //CleanUp
        userRepository.deleteById((user.getId()));
    }

    @Test
    public void findUsersTest() {
        //Given
        User secondUser = new User();

        secondUser.setUsername("user2");
        secondUser.setUserKey(2L);
        secondUser.setContent(true);
        //When
        userRepository.save(user);
        userRepository.save(secondUser);
        //Then
        assertEquals(2, userRepository.findAll().size());
        //CleanUp
        userRepository.deleteById(user.getId());
        userRepository.deleteById(secondUser.getId());
    }

    @Test
    public void testUserCartRelation() {
        //Given
        //When
        userRepository.save(user);
        //Then
        Assertions.assertTrue(cartRepository.findById(cart.getId()).isPresent());
        //CleanUp
        userRepository.deleteById(user.getId());
    }

    @Test
    public void checkIfOrdersAreRemoved() {
        //Given
        Order order = new Order();
        order.setExecution("in progress");
        order.setOrderDate(LocalDateTime.now());
        user.getOrders().add(order);
        order.setUser(user);
        //When
        userRepository.save(user);
        orderRepository.save(order);
        userRepository.deleteById(user.getId());
        //Then
        Assertions.assertFalse(orderRepository.findById(order.getId()).isPresent());
    }
}




