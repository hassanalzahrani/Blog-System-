package com.example.blogsystem.REpository;

import com.example.blogsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);


    User findByEmail(String email);

    List<User> findAllByRegistrationDateBefore(LocalDate date);



}
