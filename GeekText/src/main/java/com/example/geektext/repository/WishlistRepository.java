package com.example.geektext.repository;

import com.example.geektext.model.Wishlist;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends MongoRepository<Wishlist, String> {

}

