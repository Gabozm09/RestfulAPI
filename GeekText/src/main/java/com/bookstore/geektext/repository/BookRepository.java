package com.bookstore.geektext.repository;

import com.bookstore.geektext.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByGenre(String genre);
    List<Book> findByRatingGreaterThanEqual(double rating);
    void discountBooksByPublisher(double discount, String publisher);
}

