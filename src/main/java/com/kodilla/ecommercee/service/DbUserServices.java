package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserData;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class DbUserServices {

    private final UserRepository userRepository;
    private final DbUserKeyService userKeyService;

    public void createUser(final User user) {
        userRepository.save(user);
    }

    public User getUserById(final Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public void updateUserKey(final Long id, String generatedKey) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        user.setUserKey(generatedKey);
        user.setKeyStartTime(LocalDateTime.now());
        createUser(user);
    }

    public void blockUser(final Long id, String key) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        Boolean isKeyValid = userKeyService.userKeyValidator(id);
        if (isKeyValid || user.getUserKey().equals(key)){
            user.setContent(false);
            createUser(user);
        } else {
            user.setUserKey(null);
            System.out.println("User key is no longer valid, create new key");
            createUser(user);
        }
    }
}
