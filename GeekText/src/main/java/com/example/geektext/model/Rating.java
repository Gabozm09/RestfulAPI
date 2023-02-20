package com.example.geektext.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ratings")
public class Rating {

    @Field("user_id")
    private String userId;

    @Field("book_id")
    private String bookId;

    @Field("rating_value")
    private int ratingValue;

    @Field("date_created")
    private Date dateCreated;

    public Rating() {
    }

    public Rating(String userId, String bookId, int ratingValue, Date dateCreated) {
        this.userId = userId;
        this.bookId = bookId;
        this.ratingValue = ratingValue;
        this.dateCreated = dateCreated;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    // Computes the average rating for a book
    public static double computeAverageRating(List<Rating> ratings) {
        if (ratings == null || ratings.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (Rating rating : ratings) {
            sum += rating.getRatingValue();
        }

        return (double) sum / ratings.size();
    }
}



