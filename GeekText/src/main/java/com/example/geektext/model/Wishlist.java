package com.example.geektext.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import java.util.List;

@Document(collection = "wishlists")
public class Wishlist {

    @Id
    private String id;

    @Field("user_id")
    private String userId;

    @Field("name")
    private String name;

    @Field("books")
    private List<String> books;

    public Wishlist() {
    }

    public Wishlist(String userId, String name, List<String> books) {
        this.userId = userId;
        this.name = name;
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}

