package com.finalproject.traveltogether.repository;

import com.finalproject.traveltogether.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {

    public User findByUserName(String username);
    public User findUserByEmail(String email);
}
