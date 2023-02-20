package com.example.geektext.Controller;

import com.example.geektext.model.User;
import com.example.geektext.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setHomeAddress(user.getHomeAddress());
            existingUser.setCreditCards(user.getCreditCards());
            existingUser.setWishlists(user.getWishlists());
            existingUser.setComments(user.getComments());
            existingUser.setShoppingCart(user.getShoppingCart());
            return userRepository.save(existingUser);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);
    }
}

