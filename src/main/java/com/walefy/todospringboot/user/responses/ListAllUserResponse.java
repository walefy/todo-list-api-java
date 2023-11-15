package com.walefy.todospringboot.user.responses;

import java.util.List;

import com.walefy.todospringboot.user.UserModel;

public class ListAllUserResponse {
    private List<UserModel> users;

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }
}
