package com.example.geektext.repository;

import com.example.geektext.model.CartItem;
import com.example.geektext.model.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

    Optional<ShoppingCart> findByUserId(String userId);

    void deleteByUserId(String userId);

    void addItem(String cartId, CartItem item);

    void removeItem(String cartId, CartItem item);
}

