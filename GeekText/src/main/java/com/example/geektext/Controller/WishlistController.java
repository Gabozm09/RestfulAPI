package com.example.geektext.Controller;

import com.example.geektext.model.Wishlist;
import com.example.geektext.repository.WishlistRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    private WishlistRepository wishlistRepository;

    @GetMapping("")
    public ResponseEntity<List<Wishlist>> getAllWishlists() {
        List<Wishlist> wishlists = wishlistRepository.findAll();
        return ResponseEntity.ok(wishlists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wishlist> getWishlistById(@PathVariable("id") String id) {
        Optional<Wishlist> wishlist = wishlistRepository.findById(id);
        return wishlist.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<Wishlist> createWishlist(@RequestBody Wishlist wishlist) {
        Wishlist newWishlist = wishlistRepository.save(wishlist);
        return ResponseEntity.ok(newWishlist);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wishlist> updateWishlist(@PathVariable("id") String id, @RequestBody Wishlist wishlist) {
        Optional<Wishlist> wishlistData = wishlistRepository.findById(id);

        if (wishlistData.isPresent()) {
            Wishlist updatedWishlist = wishlistData.get();
            updatedWishlist.setUserId(wishlist.getUserId());
            updatedWishlist.setBooks(wishlist.getBooks());
            Wishlist savedWishlist = wishlistRepository.save(updatedWishlist);
            return ResponseEntity.ok(savedWishlist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWishlist(@PathVariable("id") String id) {
        Optional<Wishlist> wishlistData = wishlistRepository.findById(id);

        if (wishlistData.isPresent()) {
            wishlistRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
