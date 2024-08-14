package com.example.blogsystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;





    @NotNull(message = "category ID should not be empty")
//@Column(unique = true, nullable = false)
@Positive(message = "category id should be positive number only ")
    private int categoryId;
//    @Column( nullable = false)
@NotEmpty(message = "title should not be empty")
private String title ;


    @NotEmpty(message = "content should not be empty")
    private String content;
    private LocalDate publishDate;
    private int userId;


}
