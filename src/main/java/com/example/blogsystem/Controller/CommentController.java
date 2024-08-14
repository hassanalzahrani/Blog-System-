package com.example.blogsystem.Controller;

import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/comment")
public class CommentController {
    private final CommentService commentService;


    @GetMapping("/get")
    public ResponseEntity getAllComments() {
        return ResponseEntity.status(200).body(commentService.getAllComments());
    }

    @PostMapping("/add")
     public ResponseEntity addComment(@Valid @RequestBody Comment comment, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);

        }
        commentService.addComment(comment);
        return ResponseEntity.status(201).body("Comment added");
    }

    @PutMapping("/update/{id}")

    public ResponseEntity updateComment(@PathVariable int id, @Valid@RequestBody Comment comment, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        commentService.updateComment(id, comment);
        return ResponseEntity.status(201).body("Comment updated");
    }
    @DeleteMapping("/delete/{id}")

public ResponseEntity deleteComment(@PathVariable int id) {
        commentService.deleteComment(id);
        return ResponseEntity.status(201).body("Comment deleted");
    }
    @GetMapping("get-comment/{postId}")
    public ResponseEntity getCommentById(@PathVariable int postId) {
        return ResponseEntity.status(200).body(commentService.getCommentsByPostId(postId));

    }

    @GetMapping("/get-byContent/{content}")

public ResponseEntity getCommentByContent(@PathVariable String content){
        return ResponseEntity.status(200).body(commentService.getCommentByContent(content));
    }

}
