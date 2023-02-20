package com.example.geektext.Controller;

import com.example.geektext.model.Rating;
import com.example.geektext.repository.RatingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping("")
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Rating getRatingById(@PathVariable String id) {
        return ratingRepository.findById(id).orElse(null);
    }

    @PostMapping("")
    public Rating addRating(@RequestBody Rating rating) {
        return ratingRepository.save(rating);
    }

    @PutMapping("/{id}")
    public Rating updateRating(@PathVariable String id, @RequestBody Rating newRating) {
        return ratingRepository.findById(id)
                .map(rating -> {
                    rating.setUserId(newRating.getUserId());
                    rating.setBookId(newRating.getBookId());
                    rating.setRatingValue(newRating.getRatingValue());
                    return ratingRepository.save(rating);
                })
                .orElseGet(() -> {
                    newRating.setBookId(id);
                    return ratingRepository.save(newRating);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable String id) {
        ratingRepository.deleteById(id);
    }

    @GetMapping("/book/{bookId}")
    public List<Rating> getRatingsByBookId(@PathVariable String bookId) {
        return ratingRepository.findByBookId(bookId);
    }



}

