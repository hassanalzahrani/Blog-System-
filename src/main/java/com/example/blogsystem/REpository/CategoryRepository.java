package com.example.blogsystem.REpository;

import com.example.blogsystem.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {


    Category findCategoryById(Integer id);

    List<Category> findCategoryByCategoryName(String categoryName);

}
