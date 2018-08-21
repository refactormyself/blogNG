package com.bolarinwa.apps.blogengine.model;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class CommentRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Before
    public void setUp(){
        User user = userRepository.save(new User(1L, "e@mail.com", "password101", "Full of Names"));
        Post post = postRepository.save(new Post(1L, user, "Title of my Post", "Content of my Post"));
        commentRepository.save(new Comment(1L, post, "guest-1", "great post. First comment, yeh!!"));
    }

    @Test
    public void findByContentContaining(){
        Collection<Comment> comments = commentRepository.findAllByContentContaining("yeh");
        Assertions.assertThat(comments.size()).isEqualTo(1);
        Assertions.assertThat(comments.iterator().next().getId()).isGreaterThan(0);
        Assertions.assertThat(comments.iterator().next().getAuthor()).isEqualTo("guest-1");

    }
}