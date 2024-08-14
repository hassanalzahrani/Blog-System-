package com.example.blogsystem.Service;

import com.example.blogsystem.Api.ApiException;
import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.REpository.CategoryRepository;
import com.example.blogsystem.REpository.PostRepository;
import com.example.blogsystem.REpository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;


    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

public  void addPost(Post post) {
        User user = userRepository.findUserById(post.getUserId());
    Category category=categoryRepository.findCategoryById(post.getCategoryId());


    if(user==null || category==null){
        throw new ApiException("user or category not found");
    }
    post.setPublishDate(LocalDate.now());
    postRepository.save(post);


}
public  void updatePost(Integer id,Post post) {
        User u = userRepository.findUserById(post.getUserId());
        Category c=categoryRepository.findCategoryById(post.getCategoryId());
        Post p=postRepository.findPostById(id);
        if(u==null || c==null){
            throw new ApiException("user or category not found");
        }
        p.setTitle(post.getTitle());
        p.setContent(post.getContent());
        postRepository.save(p);
}

public  void deletePost(Integer id) {
            Post post=postRepository.findPostById(id);
         if(post==null){
             throw new ApiException("post not found");
         }

         postRepository.delete(post);
}

    public Post getPostByTitle(String title) {
        return postRepository.findByTitle(title);
    }


    public List<Post> getAllPostsBeforeDate(LocalDate date) {
        return postRepository.findAllByPublishDateBefore(date);
    }

    public List<Post> getAllPostsByCategoryId(Integer categoryId) {
        return postRepository.findAllByCategoryId(categoryId);
    }

}
