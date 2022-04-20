package com.codeup.springblog.models;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

public class User {
    private long id;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

    public User(){}

    public User(long id, String username, String password, List<Post> posts) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.posts = posts;
    }

    public User(User copy) {
        this.id = copy.id;
        this.username = copy.username;
        this.password = copy.password;
        this.posts = copy.posts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
