package com.soncao.myrecipeapp.serviceImpl;


import com.soncao.myrecipeapp.exception.custom.NoContentException;
import com.soncao.myrecipeapp.exception.custom.NotFoundException;
import com.soncao.myrecipeapp.model.User;
import com.soncao.myrecipeapp.repository.UserRepository;
import com.soncao.myrecipeapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        log.info("Retrieving user {} from DB", username);

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public User getUserById(Long id) {
        log.info("Retrieving user {} from DB", id);

        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        log.info("Retrieving all users");

        List<User> userList = userRepository.findAll();

        if (userList.isEmpty()) {
            throw new NoContentException("No users found");
        }

        return userList;
    }
}
