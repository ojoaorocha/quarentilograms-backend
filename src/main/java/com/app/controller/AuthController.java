package com.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login() {
        return "todo";
    }

    @PostMapping("/logout")
    public String logout() {
        return "todo";
    }
}
