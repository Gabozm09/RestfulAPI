package com.example.geektext.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "books")
public class Book {

    @Id
    private String id;

    @Field("title")
    private String title;

    @Field("author")
    private String author;

    @Field("genre")
    private String genre;

    @Field("price")
    private double price;

    @Field("publisher")
    private String publisher;

    @Field("year_published")
    private int yearPublished;

    @Field("copies_sold")
    private int copiesSold;

    @Field("comments")
    private List<Comment> comments;

    @Field("ratings")
    private List<Rating> ratings;

    public Book() {
        comments = new ArrayList<>();
        ratings = new ArrayList<>();
    }

    public Book(String title, String author, String genre, double price, String publisher, int yearPublished, int copiesSold) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.copiesSold = copiesSold;
        this.comments = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public int getPublicationYear() {
        return yearPublished;
    }

    public void setPublicationYear(int yearPublished) {
        this.yearPublished = yearPublished;
    }


    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}