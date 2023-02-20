package com.example.geektext.repository;

import com.example.geektext.model.Rating;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {

    List<Rating> findByUserId(String userId);

    List<Rating> findByBookId(String bookId);

    Rating findByUserIdAndBookId(String userId, String bookId);

}

