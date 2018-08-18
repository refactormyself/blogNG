package com.bolarinwa.apps.blogengine.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommentTest {

    @Test
    public void creation(){
        User user = new User("me@email.net", "hidden_secret", "All-names-goes");
        Post post1 = new Post(user, "Hot Title - 1", "1 - 1 Cool Contents with lots of RANT");

        Comment comment1 = new Comment(post1, "commentor1", "just a short comment");
        Comment comment2 = new Comment(post1, "commentor1", "another short comment");
        Comment comment3 = new Comment(post1, "commentor2", " comment by commentor 2");

        Assertions.assertThat(comment1.getAuthor()).isEqualTo("commentor1");
        Assertions.assertThat(comment2.getAuthor()).isEqualTo(comment1.getAuthor());
        Assertions.assertThat(comment3.getContent()).isEqualTo(" comment by commentor 2");
    }
}