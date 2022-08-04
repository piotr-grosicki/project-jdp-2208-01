package com.kodilla.ecommercee.domain;


import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTestSuite {

    @Autowired
    UserRepository userRepository;
    public User user = new User();

    @Before
    public void userTest() {
       // user.setId(1L);
        user.setUsername("user1");
        user.setUserKey(1L);
        user.setContent(true);

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
        assertEquals(2,userRepository.findAll().size());
        //CleanUp
        userRepository.deleteById(user.getId());
        userRepository.deleteById(secondUser.getId());
    }
}




