package com.bolarinwa.apps.blogengine.controller;

import com.bolarinwa.apps.blogengine.model.Post;
import com.bolarinwa.apps.blogengine.model.PostRepository;
import com.bolarinwa.apps.blogengine.model.User;
import com.bolarinwa.apps.blogengine.model.UserRepository;
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
public class PostRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PostRepository postRepository;
    @MockBean
    private UserRepository userRepository;

    User user1;
    User user2;

    @Before
    public void setUp(){
        user1 = new User(1L, "me@email.net", "pass", "me");
        user2 = new User(1L, "guest@email.net", "pass1234", "guest");

        Mockito.when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));
        Mockito.when(postRepository.findAll()).thenReturn(Arrays.asList(
                new Post(1L, user1, "My first Blog", "Itan Ijapa ati Aja pelu Yanibo"),
                new Post(2L, user2, "My first Blog", "Itan Ijapa ati Aja pelu Yanibo")
        ));
    }

    @Test
    public void getAllPosts() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/posts"))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1))//new GreaterThan(0)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

