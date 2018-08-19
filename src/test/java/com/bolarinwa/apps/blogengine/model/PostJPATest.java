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
public class PostJPATest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void postEntityMapping(){
        User user = testEntityManager.persist(
                new User("me@email.net", "hidden_secret", "All-names-goes"));
        Post post1 = testEntityManager.persistFlushFind(
                new Post(user, "Hot Title - 1", "1 - 1 Cool Contents with lots of RANT"));
        Post post2 = testEntityManager.persistFlushFind(
                new Post(user, "Hot Title - 2", "2 - 2 Cool Contents with lots of RANT"));

        Assertions.assertThat(post1.getAuthor()).isEqualTo(user);
        Assertions.assertThat(post1.getAuthor()).isEqualTo(post2.getAuthor());
        Assertions.assertThat(post1.getTitle()).isEqualTo("Hot Title - 1");
        Assertions.assertThat(post2.getContent()).isEqualTo("2 - 2 Cool Contents with lots of RANT");

    }
}