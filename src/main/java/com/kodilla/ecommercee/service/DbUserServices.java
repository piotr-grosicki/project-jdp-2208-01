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

    public void createUser(final User user) {
        userRepository.save(user);
    }

    public User getUserById(final Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public void blockUser(UserData userData, Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        generateUserKey(userId, user.getPassword());
        userKeyValidator(user);
        if (user.getPassword().equals(userData.getPassword())) {
            user.setContent(false);
        } else {
            System.out.println("User is already blocked");
        }
    }

    public void unlockUser(UserData userData, Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        generateUserKey(userId, user.getPassword());
        userKeyValidator(user);
        if (user.getPassword().equals(userData.getPassword())) {
            if (!user.getContent()) {
                user.setContent(true);
            } else {
                System.out.println("User is already unlocked");
            }
        } else {
            System.out.println("Wrong password");
        }
    }

    public void generateUserKey(final Long id, String password) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        long leftLimit = 1L;
        long rightLimit = 10L;
        if (user.getPassword().equals(password)) {
            if (user.getContent()) {
                Long generatedKey = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
                user.setUserKey(generatedKey);
                user.setKeyStartTime(LocalDateTime.now());
                userRepository.save(user);
            } else {
                System.out.println("User is blocked");
            }
        } else {
            System.out.println("Incorrect credentials");
        }
    }

    public void userKeyValidator(User user) {
        if (user.getUserKey() != null){
            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime creationTime = user.getKeyStartTime();
            if(ChronoUnit.HOURS.between(creationTime, currentTime) >= 1 || !user.getContent()) {
                user.setUserKey(null);
                user.setKeyStartTime(null);
                userRepository.save(user);
            }
        }
    }
}
