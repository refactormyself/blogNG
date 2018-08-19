package com.bolarinwa.apps.blogengine.controller;

import com.bolarinwa.apps.blogengine.model.User;
import com.bolarinwa.apps.blogengine.model.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.Collection;
import java.util.Collections;

@RestController
public class UserRestController {

    private final UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Collection<User> users(){
//        return Collections.emptyList();
        return userRepository.findAll();
    }
}
