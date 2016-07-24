package com.test.mapper.model;

import java.util.List;

/**
 * Created by miaorf on 2016/7/20.
 */
public class Blog {
    private Integer id;
    private String name;
    private Author author;
    private Author coAuthor;
    private List<Post> posts;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getCoAuthor() {
        return coAuthor;
    }

    public void setCoAuthor(Author coAuthor) {
        this.coAuthor = coAuthor;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                '}';
    }
}
