package com.example.geektext.Controller;

import com.example.geektext.model.Comment;
import com.example.geektext.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;




@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @PostMapping("/")
    public Comment addComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @GetMapping("/")
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable(value = "id") String commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            return ResponseEntity.ok().body(comment.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable(value = "id") String commentId, @RequestBody Comment comment) {
        Optional<Comment> existingComment = commentRepository.findById(commentId);
        if (existingComment.isPresent()) {
            Comment updatedComment = existingComment.get();
            updatedComment.setBookId(comment.getBookId());
            updatedComment.setUserId(comment.getUserId());
            updatedComment.setCommentText(comment.getCommentText());
            Comment savedComment = commentRepository.save(updatedComment);
            return ResponseEntity.ok(savedComment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable(value = "id") String commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            commentRepository.delete(comment.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

