package com.walefy.todospringboot.user.responses;

import org.springframework.http.HttpStatus;

import com.walefy.todospringboot.user.UserModel;

public class UserCreationResult {
    private UserModel user;
    private String message;
    private HttpStatus status;
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}