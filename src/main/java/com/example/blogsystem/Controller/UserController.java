package com.example.blogsystem.Controller;

import com.example.blogsystem.Model.User;
import com.example.blogsystem.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;


@GetMapping("/get")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }


    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors){
    if(errors.hasErrors()){
        String message = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }

    userService.addUser(user);
    return ResponseEntity.status(201).body(" user added successfully");
      }

      @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable int id, @Valid @RequestBody User user, Errors errors){
    if(errors.hasErrors()){
        String message = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);

    }
    userService.updateUser(id, user);
    return ResponseEntity.status(201).body(user);
      }
      @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable int id){
    userService.deleteUser(id);
    return ResponseEntity.status(201).body("User deleted successfully");
      }

    @GetMapping("/user-by-email/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email) {
        return ResponseEntity.status(200).body(userService.getUserByEmail(email));
    }

    @GetMapping("/users-before-date/{date}")
    public ResponseEntity getAllUsersBeforeRegistrationDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return ResponseEntity.status(200).body(userService.getAllUsersBeforeRegistrationDate(localDate));
    }





}
