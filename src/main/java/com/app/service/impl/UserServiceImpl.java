package com.app.service.impl;

import com.app.model.User;
import com.app.repository.UserRepository;
import com.app.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public void registerNewUser(String userJSON) throws JsonProcessingException {
        User user = new ObjectMapper().readValue(userJSON, User.class);
        this.userRepository.save(user);
    }
}
