package com.bolarinwa.apps.blogengine.controller;

import com.bolarinwa.apps.blogengine.model.Post;
import com.bolarinwa.apps.blogengine.model.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class PostRestController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Collection<Post> posts(){
        return postRepository.findAll();
    }
}