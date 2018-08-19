package com.bolarinwa.apps.blogengine.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUserName(){
        this.userRepository.save(new User("saheed@myself.com", "pandora-box-key", "Words Full of Names"));

        Collection<User> usersByName = this.userRepository.findByFullname("Words Full of Names");
        Assertions.assertThat(usersByName.size()).isEqualTo(1);
        Assertions.assertThat(usersByName.iterator().next().getId()).isGreaterThan(0);
        Assertions.assertThat(usersByName.iterator().next().getFullname()).isEqualTo("Words Full of Names");

    }
}