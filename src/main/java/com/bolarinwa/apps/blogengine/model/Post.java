package com.bolarinwa.apps.blogengine.model;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Post {
 
    public String title;
    public Date postedAt;
    
    @Lob
    public String content;
    
    @ManyToOne
    public User author;
    
    public Post(User author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.postedAt = new Date();
    }
 
}