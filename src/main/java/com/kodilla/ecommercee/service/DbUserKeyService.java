package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserData;
import com.kodilla.ecommercee.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class DbUserKeyService {

    private final UserRepository userRepository;

    public String generateUserKey() {
        return RandomString.make(10);
    }

    public Boolean userKeyValidator(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        LocalDateTime currentTime = LocalDateTime.now();
        return ChronoUnit.HOURS.between(user.getKeyStartTime(), currentTime) <= 1;
    }

    public Boolean checkUser(UserData userData, Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return user.getUsername().equals(userData.getUsername()) || user.getPassword().equals(userData.getPassword());
    }
}

