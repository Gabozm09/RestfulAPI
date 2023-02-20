package com.bookstore.geektext.controller;

import com.bookstore.geektext.entity.CreditCard;
import com.bookstore.geektext.entity.User;
import com.bookstore.geektext.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    @PutMapping("/{username}")
    public void updateUserByUsername(@PathVariable String username, @RequestBody User user) {
        User existingUser = userRepository.findByUsername(username);
        existingUser.setPassword(user.getPassword());
        existingUser.setName(user.getName());
        existingUser.setAddress(user.getAddress());
        existingUser.setCreditCard(user.getCreditCard());
        userRepository.save(existingUser);
    }

    @PostMapping("/{username}/credit-card")
    public void addCreditCardToUser(@PathVariable String username, @RequestBody CreditCard creditCard) {
        User existingUser = userRepository.findByUsername(username);
        existingUser.setCreditCard(creditCard);
        userRepository.save(existingUser);
    }
}
