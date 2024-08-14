package com.example.blogsystem.Controller;

import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/get")
    public ResponseEntity getPost() {
        return ResponseEntity.status(200).body(postService.getAllPosts());


    }

    @PostMapping("/add")
    public ResponseEntity addPost(@Valid @RequestBody Post post, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);

        }
        postService.addPost(post);
        return ResponseEntity.status(201).body("Post added successfully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@PathVariable int id ,@Valid @RequestBody Post post, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        postService.updatePost(id, post);
        return ResponseEntity.status(201).body("Post updated successfully");
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deletePost(@PathVariable int id) {
        postService.deletePost(id);
        return ResponseEntity.status(201).body("Post deleted successfully");
    }

    @GetMapping("/get-by-title/{title}")
    public ResponseEntity getPostByTitle(@PathVariable String title) {
        return ResponseEntity.status(200).body(postService.getPostByTitle(title));
    }

    @GetMapping("/get-before-date/{date}")
    public ResponseEntity getAllPostsBeforeDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return ResponseEntity.status(200).body(postService.getAllPostsBeforeDate(localDate));
    }

    @GetMapping("/posts-by-category/{categoryId}")
    public ResponseEntity getAllPostsByCategoryId(@PathVariable Integer categoryId) {
        return ResponseEntity.status(200).body(postService.getAllPostsByCategoryId(categoryId));
    }



}
