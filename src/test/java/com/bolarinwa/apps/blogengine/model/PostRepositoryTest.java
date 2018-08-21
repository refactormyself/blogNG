package com.bolarinwa.apps.blogengine.model;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    private User user;
    @Before
    public void setUp() throws Exception {
        user = userRepository.save(new User(1L, "e@mail.com", "password101", "Full of Names"));
        postRepository.save(new Post(1L, user, "Title of my Post", "Content of my Post"));
    }

    @Test
    public void findAllByTitleContains(){
        Collection<Post> postsByName = postRepository.findAllByTitleContains("my");
        Assertions.assertThat(postsByName.size()).isEqualTo(1);
        Assertions.assertThat(postsByName.iterator().next().getId()).isGreaterThan(0);
        Assertions.assertThat(postsByName.iterator().next().getContent().contains("Names"));
    }

    @Ignore
    @Test
    public void findAllByAuthor(){

        //ToDo: SQL Query for author
//        Collection<Post> postsByName = postRepository.findAllByAuthor("Full of Names");

    }

}