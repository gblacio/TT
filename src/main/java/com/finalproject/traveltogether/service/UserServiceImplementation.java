package com.finalproject.traveltogether.service;

import com.finalproject.traveltogether.entity.User;
import com.finalproject.traveltogether.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    @Transactional(readOnly = true)
    public List<User> userList() {
        return (List<User>) userDAO.findAll();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDAO.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUser(User user) {
        return userDAO.findById(user.getUserID()).orElse(null);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDAO.findByUserName(username);
    }

    @Override
    public User findUserByEmail(String email) {
        return userDAO.findUserByEmail(email);
    }
}
