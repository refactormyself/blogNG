package com.bolarinwa.apps.blogengine.model;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void creation(){
        User user = new User("me@email.net", "hidden_secret", "All-names-goes");
        assertTrue(user.getEmail().equals("me@email.net"));
        Assert.assertThat(user.getPassword(), Matchers.equalTo("hidden_secret"));
        Assertions.assertThat(user.getFullname()).isEqualTo("All-names-goes");

    }
    


}