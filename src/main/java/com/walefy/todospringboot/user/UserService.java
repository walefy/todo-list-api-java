package com.walefy.todospringboot.user;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.walefy.todospringboot.user.responses.UserCreationResult;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserCreationResult createUser(UserModel newUser) {
        var user = userRepository.findByUsername(newUser.getUsername());
        var response = new UserCreationResult();

        if (user != null) {
            response.setMessage("Username already exists");
            response.setStatus(HttpStatus.CONFLICT);
            return response;
        }

        var hashPassword = BCrypt.withDefaults().hashToString(12, newUser.getPassword().toCharArray());
        newUser.setPassword(hashPassword);

        var userCreated = this.userRepository.save(newUser);
        response.setUser(userCreated);
        response.setMessage("User created successfully");
        response.setStatus(HttpStatus.CREATED);

        return response;
    }
}
