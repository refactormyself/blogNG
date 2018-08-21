package com.bolarinwa.apps.blogengine.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
//@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private String author;
    private Date postedAt;
    @Lob
    private String content;
    
    @ManyToOne
    public Post post;
    
    public Comment(Long id, Post post, String author, String content) {
        this.id = id;
        this.post = post;
        this.author = author;
        this.content = content;
        this.postedAt = new Date();
    }
 
}