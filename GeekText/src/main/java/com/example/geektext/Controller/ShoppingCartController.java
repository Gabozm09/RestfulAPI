package com.example.geektext.Controller;

import com.example.geektext.model.User;
import com.example.geektext.model.Book;
import com.example.geektext.model.CartItem;
import com.example.geektext.model.ShoppingCart;
import com.example.geektext.repository.BookRepository;
import com.example.geektext.repository.ShoppingCartRepository;
import com.example.geektext.repository.UserRepository;
import com.example.geektext.repository.ShoppingCartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userId}/subtotal")
    public double getCartSubtotal(@PathVariable String userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            ShoppingCart cart = user.get().getShoppingCart();
            List<CartItem> cartItems = cart.getCartItems();
            double subtotal = 0.0;
            for (CartItem cartItem : cartItems) {
                Optional<Book> book = bookRepository.findById(cartItem.getBookId());
                if (book.isPresent()) {
                    subtotal += book.get().getPrice() * cartItem.getQuantity();
                }
            }
            return subtotal;
        }
        return 0.0;
    }

    @PostMapping("/{userId}/items")
    public void addToCart(@PathVariable String userId, @RequestBody CartItem cartItem) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            ShoppingCart cart = user.get().getShoppingCart();
            List<CartItem> cartItems = cart.getCartItems();
            boolean itemFound = false;
            for (CartItem item : cartItems) {
                if (item.getBookId().equals(cartItem.getBookId())) {
                    item.setQuantity(item.getQuantity() + cartItem.getQuantity());
                    itemFound = true;
                    break;
                }
            }
            if (!itemFound) {
                cartItems.add(cartItem);
            }
            cart.setCartItems(cartItems);
            shoppingCartRepository.save(cart);
        }
    }

    @GetMapping("/{userId}/items")
    public List<Book> getCartItems(@PathVariable String userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            ShoppingCart cart = user.get().getShoppingCart();
            List<CartItem> cartItems = cart.getCartItems();
            List<Book> books = new ArrayList<>();
            for (CartItem cartItem : cartItems) {
                Optional<Book> book = bookRepository.findById(cartItem.getBookId());
                if (book.isPresent()) {
                    books.add(book.get());
                }
            }
            return books;
        }
        return null;
    }

    @DeleteMapping("/{userId}/items/{bookId}")
    public void removeFromCart(@PathVariable String userId, @PathVariable String bookId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            ShoppingCart cart = user.get().getShoppingCart();
            List<CartItem> cartItems = cart.getCartItems();
            for (CartItem item : cartItems) {
                if (item.getBookId().equals(bookId)) {
                    cartItems.remove(item);
                    break;
                }
            }
            cart.setCartItems(cartItems);
            shoppingCartRepository.save(cart);
        }
    }
}

