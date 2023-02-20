package com.example.geektext.model;

import com.example.geektext.repository.CommentRepository;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document(collection = "comments")
public class Comment {

    @Id
    private String id;

    @Field("user_id")
    private String userId;

    @Field("book_id")
    private String bookId;

    @Field("comment_text")
    private String commentText;

    @Field("date_created")
    private Date dateCreated;

    public Comment() {
    }

    public Comment(String userId, String bookId, String commentText, Date dateCreated) {
        this.userId = userId;
        this.bookId = bookId;
        this.commentText = commentText;
        this.dateCreated = dateCreated;
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

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    // Logic for retrieving all comments for a particular book
    // Logic for retrieving all comments for a particular book
    public static List<Comment> getAllCommentsForBook(String bookId, CommentRepository repository) {
        List<Comment> comments = repository.findByBookId(bookId);
        return comments;
    }

}

