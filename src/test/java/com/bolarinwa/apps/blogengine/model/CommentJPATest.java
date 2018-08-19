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
public class CommentJPATest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void commentEntityMapping(){
        User user = testEntityManager.persist(
                new User("me@email.net", "hidden_secret", "All-names-goes"));
        Post post1 = testEntityManager.persist(
                new Post(user, "Hot Title - 1", "1 - 1 Cool Contents with lots of RANT"));

        Comment comment1 = testEntityManager.persistFlushFind(
                new Comment(post1, "commentor1", "just a short comment"));
        Comment comment2 = testEntityManager.persistFlushFind(
                new Comment(post1, "commentor1", "another short comment"));

        Assertions.assertThat(comment1.getId()).isGreaterThan(0);
        Assertions.assertThat(comment1.getAuthor()).isEqualTo("commentor1");
        Assertions.assertThat(comment1.getAuthor()).isEqualTo(comment2.getAuthor());
        Assertions.assertThat(comment2.getContent()).isEqualTo("another short comment");
        Assertions.assertThat(comment2.getPost().getAuthor().getEmail()).isEqualTo("me@email.net");
        Assertions.assertThat(comment2.getPost().getAuthor()).isEqualTo(comment1.getPost().getAuthor());

    }
}