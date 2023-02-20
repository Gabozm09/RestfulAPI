package com.example.geektext.repository;

import com.example.geektext.model.Book;
import com.example.geektext.model.Comment;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByGenre(String genre);
    List<Book> findTop10ByOrderByCopiesSoldDesc();
    List<Book> findByRatingGreaterThanEqual(double rating);
    List<Book> findByPublisher(String publisher);
    List<Comment> findByBookId(String bookId);
}
