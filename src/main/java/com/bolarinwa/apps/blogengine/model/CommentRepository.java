package com.bolarinwa.apps.blogengine.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CommentRepository extends JpaRepository<Comment, Long>{

    Collection<Comment> findAllByContentContaining(String text);
}
