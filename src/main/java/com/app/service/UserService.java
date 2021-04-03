package com.app.service;

import com.app.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Optional;

public interface UserService {

    public Iterable<User> getAllUsers();

    public Optional<User> getUserById(long id);

    public void deleteUserById(long id);

    public void registerNewUser(String userJSON) throws JsonProcessingException;
}
