package com.bolarinwa.apps.blogengine.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserJPATest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void userEntityMapping(){
        User me = testEntityManager.persistFlushFind(new User("me@email.net", "hidden_secret", "All-names-goes"));
        Assertions.assertThat(me.getFullname()).isEqualTo("All-names-goes");
        Assertions.assertThat(me.getEmail()).isEqualTo("me@email.net");
        Assertions.assertThat(me.getPassword()).isEqualTo("hidden_secret");
        Assertions.assertThat(me.getId()).isNotNull();
        Assertions.assertThat(me.getId()).isGreaterThan(0);

    }

}