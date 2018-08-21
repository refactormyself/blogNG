package com.bolarinwa.apps.blogengine.controller;

import com.bolarinwa.apps.blogengine.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.junit.Assert.*;

@WebMvcTest
@RunWith(SpringRunner.class)
public class CommentRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CommentRepository commentRepository;
    @MockBean
    private PostRepository postRepository;
    @MockBean
    private UserRepository userRepository;

    private User user;
    private Post post1;
    private Post post2;

    @Before
    public void setUp(){
        user = new User(1L, "me@email.net", "pass", "me");
        post1 = new Post(1L, user, "My first Blog", "Itan Ijapa ati Aja pelu Yanibo");
        post2 = new Post(2L, user, "Another Blog", "Itan Iya Risi alata ati Yanibo");

        Mockito.when(commentRepository.findAll()).thenReturn(Arrays.asList(
                new Comment(1L, post1, "guess-2", "Hey, 1st commnter"),
                new Comment(2L, post2, "guess-1", "1, Commented ---"),
                new Comment(3L, post1, "guess-1", "2, Commented ---"),
                new Comment(4L, post2, "guess-1", "3, Commented ---")
        ));
    }

    @Test
    public void getAllComments() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/comments"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}