package com.finalproject.traveltogether.service;

import com.finalproject.traveltogether.entity.User;

import java.util.List;

public interface UserService {
    public List<User> userList();
    public void saveUser(User user);
    public void deleteUser(User user);
    public  User findUser(User user);
    public User findUserByUsername(String username);
    public User findUserByEmail(String email);
}
