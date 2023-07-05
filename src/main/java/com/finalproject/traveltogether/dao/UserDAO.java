package com.finalproject.traveltogether.dao;

import com.finalproject.traveltogether.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long> {
}
