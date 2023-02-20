package com.example.geektext.repository;

import com.example.geektext.model.CreditCard;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends MongoRepository<CreditCard, String> {

    List<CreditCard> findByUserId(String userId);

}
