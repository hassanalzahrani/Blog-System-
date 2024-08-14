package com.example.blogsystem.Controller;

import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/get")

    public ResponseEntity getCategory(){
        return ResponseEntity.status(200).body(categoryService.getAllCategory());

    }

    @PostMapping("/add")

    public ResponseEntity addCategory(@Valid @RequestBody Category category, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body("Category added successfully");
    }
    @PutMapping("/update/{id}")

    public ResponseEntity updateCategory(@PathVariable int id, @Valid @RequestBody Category category,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.updateCategory(id, category);
        return ResponseEntity.status(200).body("Category updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
        return ResponseEntity.status(200).body("Category deleted successfully");
    }

    @GetMapping("/get-category-name{name}")
public ResponseEntity getCategoryName(@PathVariable String name) {
        return ResponseEntity.status(200).body(categoryService.getCategoryByCategoryName(name));

    }
}
