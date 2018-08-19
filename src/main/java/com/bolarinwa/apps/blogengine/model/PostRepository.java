package com.bolarinwa.apps.blogengine.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PostRepository extends JpaRepository<Post, Long> {

/*
    default Collection<Post> findAllByAuthorName(String names) {
        return null;
    }
*/

//    Collection<Post> findAllByAuthor(String name);

    Collection<Post> findAllByTitleContains(String title);
}
