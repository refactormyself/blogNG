package com.bolarinwa.apps.blogengine.controller;

import com.bolarinwa.apps.blogengine.model.User;
import com.bolarinwa.apps.blogengine.model.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.matchers.GreaterThan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.junit.Assert.*;

@WebMvcTest
@RunWith(SpringRunner.class)
public class UserRestControllerTest {
/*

    @Configuration
    public static class ConfigMockitoUserRepo{
        @Bean
        UserRepository userRepository(){
            UserRepository mock = Mockito.mock(UserRepository.class);
            Mockito.when(mock.findAll()).thenReturn(Arrays.asList(
                                    new User("me@email.net", "pass", "me")));
            return  mock;
        }
    }
*/

    @MockBean
    private UserRepository mockedUserRepository;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        Mockito.when(mockedUserRepository.findAll()).thenReturn(Arrays.asList(
                new User(1L, "me@email.net", "pass", "me")
        ));
    }

    @Test
    public void getUsers() throws Exception {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                    .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void mediaType() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void getUserEmail() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].email").value("me@email.net"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getUserFullName() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].fullname").value("me"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getUserId() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1))//new GreaterThan(0)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

//    /user/q=
}