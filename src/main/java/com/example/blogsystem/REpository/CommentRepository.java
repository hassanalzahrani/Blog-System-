package com.example.blogsystem.REpository;

import com.example.blogsystem.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface CommentRepository  extends JpaRepository<Comment, Long> {

    Comment findCommentById(Integer id);


List<Comment>findCommentByPostId(int postId);

public Comment findCommentByContent(String content);

List<Comment>findCommentByCommentDateAfter(LocalDate commentDate);




}
