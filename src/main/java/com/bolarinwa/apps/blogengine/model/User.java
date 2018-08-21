package com.bolarinwa.apps.blogengine.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import javax.persistence.*;
 
//@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String password;
    private String fullname;
    private boolean isAdmin;
    
    public User(Long id, String email, String password, String fullname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }

}