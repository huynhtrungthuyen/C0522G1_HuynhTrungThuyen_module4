package com.example.service.security;

import com.example.model.security.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(Integer id);
}
