package com.walefy.todospringboot.user;

import org.springframework.web.bind.annotation.RestController;

import com.walefy.todospringboot.user.responses.ListAllUserResponse;
import com.walefy.todospringboot.user.responses.UserCreationResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
public class UserController {

    @Autowired
    private UserRepository UserRepository;

    @PostMapping("/user")
    public ResponseEntity<UserCreationResponse> createUser(@RequestBody UserModel userModel) {
        var service = new UserService(UserRepository);
        var serviceResponse = service.createUser(userModel);
        var response = new UserCreationResponse(serviceResponse.getUser(), serviceResponse.getMessage());

        return ResponseEntity.status(serviceResponse.getStatus()).body(response);
    }

    @GetMapping("/user")
    public ResponseEntity<ListAllUserResponse> getUser() {
        var response = new ListAllUserResponse();
        var users = this.UserRepository.findAll();
        response.setUsers(users);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        UserRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
