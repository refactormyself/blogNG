package com.bolarinwa.apps.blogengine.controller;

import com.bolarinwa.apps.blogengine.model.Comment;
import com.bolarinwa.apps.blogengine.model.CommentRepository;
import com.bolarinwa.apps.blogengine.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CommentRestController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(value = "/comments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Collection<Comment> comments(){
        return commentRepository.findAll();
    }

}