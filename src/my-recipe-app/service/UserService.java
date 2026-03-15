package com.soncao.myrecipeapp.service;

import com.soncao.myrecipeapp.model.User;

import java.util.List;

public interface UserService {
    User getUserByUsername(String username);

    User getUserById(Long id);


    List<User> getAllUsers();
}

