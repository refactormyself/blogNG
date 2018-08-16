package com.bolarinwa.apps.blogengine.model;

import java.util.*;
import javax.persistence.*;
 

@Entity
public class User {
 
    public String email;
    public String password;
    public String fullname;
    public boolean isAdmin;
    
    public User(String email, String password, String fullname) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }
 
}