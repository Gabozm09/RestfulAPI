package com.bookstore.geektext.controller;

import com.bookstore.geektext.entity.Book;
import com.bookstore.geektext.entity.CartItem;
import com.bookstore.geektext.entity.User;
import com.bookstore.geektext.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/cart")
public class ShoppingCartController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public void addBookToCart(@PathVariable String userId, @RequestParam String bookId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Book book = user.getBookById(bookId);
        if (book == null) {
            throw new ResourceNotFoundException("Book not found");
        }

        CartItem cartItem = user.getCartItemByBookId(bookId);
        if (cartItem == null) {
            cartItem = new CartItem(book, 1);
            user.getCart().add(cartItem);
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        }

        userRepository.save(user);
    }

    @GetMapping
    public List<CartItem> getCartItems(@PathVariable String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return user.getCart();
    }

    @GetMapping("/subtotal")
    public double getCartSubtotal(@PathVariable String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return user.getCartSubtotal();
    }

    @DeleteMapping("/{bookId}")
    public void removeBookFromCart(@PathVariable String userId, @PathVariable String bookId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.removeCartItemByBookId(bookId);
        userRepository.save(user);
    }
}
