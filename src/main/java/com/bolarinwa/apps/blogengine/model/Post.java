package com.bolarinwa.apps.blogengine.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
//@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Date postedAt;
    @Lob
    private String content;
    
    @ManyToOne
    private User author;

    @OneToMany(mappedBy="post", cascade=CascadeType.ALL)
    public List<Comment> comments;

    public Post(Long id, User author, String title, String content) {
        this.id = id;
        this.comments = new ArrayList<>();
        this.author = author;
        this.title = title;
        this.content = content;
        this.postedAt = new Date();
    }

}