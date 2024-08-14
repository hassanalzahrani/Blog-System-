package com.example.blogsystem.REpository;

import com.example.blogsystem.Model.Post;
import com.example.blogsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {


Post findPostById(Integer id);

    Post findByTitle(String title);

    List<Post> findAllByPublishDateBefore(LocalDate date);

    List<Post> findAllByCategoryId(Integer categoryId);


}
