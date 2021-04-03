package com.app.controller;

import com.app.model.User;
import com.app.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allUsers")
    public Iterable<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @PostMapping("/registerUser")
    public ResponseEntity registerNewUser(@RequestBody String userJSON) throws JsonProcessingException {
        this.userService.registerNewUser(userJSON);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deleteUser/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") String id) {
        this.userService.deleteUserById(Long.parseLong(id));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity getUserById(@PathVariable("id") String id) {
        return Optional.ofNullable(this.userService.getUserById(Long.parseLong(id)))
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

}
