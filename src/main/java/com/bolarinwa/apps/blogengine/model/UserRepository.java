package com.bolarinwa.apps.blogengine.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User, Long>{

    Collection<User> findByFullname(String name);
}
