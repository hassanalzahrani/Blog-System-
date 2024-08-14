package com.example.blogsystem.Service;

import com.example.blogsystem.Api.ApiException;
import com.example.blogsystem.Model.Category;
import com.example.blogsystem.REpository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public List<Category> getAllCategory() {
  return categoryRepository.findAll();

    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Integer id,Category category){
        Category c = categoryRepository.findCategoryById(id);
        if(c == null){
            throw new ApiException("Category not found");


        }
        c.setCategoryName(category.getCategoryName());
        categoryRepository.save(c);
    }

    public void deleteCategory(Integer id){
        Category c = categoryRepository.findCategoryById(id);
        if(c == null){
            throw new ApiException("Category not found");
        }
        categoryRepository.delete(c);
    }

    public List<Category> getCategoryByCategoryName(String categoryName){
        
       List<Category> categories=categoryRepository.findCategoryByCategoryName(categoryName);
       if(categories == null){
           throw new ApiException("Category not found");

       }
return categories;

    }


}
