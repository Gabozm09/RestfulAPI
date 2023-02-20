package com.example.geektext.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    @Field("username")
    private String username;

    @Field("password")
    private String password;

    @Field("name")
    private String name;

    @Field("email")
    private String email;

    @Field("home_address")
    private String homeAddress;

    @Field("credit_cards")
    private List<CreditCard> creditCards;

    @Field("wishlists")
    private List<String> wishlists;

    @Field("comments")
    private List<Comment> comments;

    @Field("shopping_cart")
    @DBRef
    private ShoppingCart shoppingCart;

    public User() {
        creditCards = new ArrayList<>();
        wishlists = new ArrayList<>();
        comments = new ArrayList<>();
        shoppingCart = new ShoppingCart();
    }

    public User(String username, String password, String name, String email, String homeAddress, List<CreditCard> creditCards, List<String> wishlists, List<Comment> comments, ShoppingCart shoppingCart) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.homeAddress = homeAddress;
        this.creditCards = creditCards;
        this.wishlists = wishlists;
        this.comments = comments;
        this.shoppingCart = shoppingCart;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public List<String> getWishlists() {
        return wishlists;
    }

    public void setWishlists(List<String> wishlists) {
        this.wishlists = wishlists;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}

