package com.example.blogsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "User Name should not be empty")
//@Column(unique = true, nullable = false,length = 15)
    @Size(min = 5, max = 15,message = "User Name must be more than")
    private String userName;
    @NotEmpty(message = "Password should not be empty")
//    @Column( nullable = false)

    private String password;
    @Email
    @NotEmpty(message = "Email should not be empty")
    private String email;
    private LocalDate registration_date;



}
