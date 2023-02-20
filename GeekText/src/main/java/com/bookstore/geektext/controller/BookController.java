package com.bookstore.geektext.controller;

import com.bookstore.geektext.entity.Book;
import com.bookstore.geektext.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping(params = "genre")
    public List<Book> getBooksByGenre(@RequestParam("genre") String genre) {
        return bookRepository.findByGenre(genre);
    }

    @GetMapping("/top-sellers")
    public List<Book> getTopSellers() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "copiesSold"));
        return bookRepository.findAll(pageable).getContent();
    }

    @GetMapping(params = "rating")
    public List<Book> getBooksByRating(@RequestParam("rating") double rating) {
        return bookRepository.findByRatingGreaterThanEqual(rating);
    }

    @PatchMapping("/discount")
    public void discountBooksByPublisher(@RequestParam("discount") double discount, @RequestParam("publisher") String publisher) {
        bookRepository.discountBooksByPublisher(discount, publisher);
    }
}

