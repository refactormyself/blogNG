package com.bolarinwa.apps.blogengine.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;


public class PostTest {

    @Test
    public void creation(){
        User user = new User("me@email.net", "hidden_secret", "All-names-goes");
        Post post1 = new Post(user, "Hot Title - 1", "1 - 1 Cool Contents with lots of RANT");
        Post post2 = new Post(user, "Hot Title - 2", "2 - 2 Cool Contents with lots of RANT");
        Post post3 = new Post(user, "Hot Title - 3", "3 - 3 Cool Contents with lots of RANT");
        Post post4 = new Post(user, "Hot Title - 4", "4 - 4 Cool Contents with lots of RANT");

        Assertions.assertThat(post1.getAuthor()).isEqualTo(post2.getAuthor());
        Assertions.assertThat(post3.getTitle()).isEqualTo("Hot Title - 3");
        Assertions.assertThat(post4.getContent()).isEqualTo("4 - 4 Cool Contents with lots of RANT");

    }

}