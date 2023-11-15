package com.walefy.todospringboot.user.responses;

import com.walefy.todospringboot.user.UserModel;

public class UserCreationResponse {
    private UserModel user;
    private String message;

    public UserCreationResponse(UserModel user, String message) {
        this.user = user;
        this.message = message;
    }
    
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
}
