package com.example.blogsystem.Service;

import com.example.blogsystem.Api.ApiException;
import com.example.blogsystem.Model.Comment;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.REpository.CommentRepository;
import com.example.blogsystem.REpository.PostRepository;
import com.example.blogsystem.REpository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }


    public void addComment(Comment comment) {
     Post post = postRepository.findPostById(comment.getPostId());
     User user = userRepository.findUserById(comment.getUserId());

     if (post == null || user == null) {
         throw new ApiException("user or post not found");
     }
     comment.setCommentDate(LocalDate.now());
     commentRepository.save(comment);
    }

    public void updateComment(Integer id, Comment comment) {
        Post post = postRepository.findPostById(comment.getPostId());
        User user = userRepository.findUserById(comment.getUserId());
        Comment c = commentRepository.findCommentById(id);
        if (post == null || user == null) {
            throw new ApiException("user or post not found");
        }
        c.setContent(comment.getContent());
    }
    public void deleteComment(Integer id) {
        Comment comment = commentRepository.findCommentById(id);
        if (comment == null) {
            throw new ApiException("comment not found");

        }
        commentRepository.delete(comment);
    }
   public List<Comment> getCommentsByPostId(int postId) {
        List<Comment> comments =commentRepository.findCommentByPostId(postId);
        return comments;


   }
public Comment getCommentByContent(String content) {
        Comment c = commentRepository.findCommentByContent(content);
        return c;


}
public List<Comment>getCommetByDate(LocalDate date) {
List<Comment>comments=commentRepository.findCommentByCommentDateAfter(date);
return comments;
}

}
