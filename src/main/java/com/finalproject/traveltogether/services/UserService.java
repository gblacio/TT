package com.finalproject.traveltogether.services;

import com.finalproject.traveltogether.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> userList();

    public void save(User user);

    public void delete(User user);

    public  User findUser(User user);
}
