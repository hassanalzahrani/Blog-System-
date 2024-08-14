package com.example.blogsystem.Service;

import com.example.blogsystem.Api.ApiException;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.REpository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        user.setRegistration_date(LocalDate.now());
        userRepository.save(user);
    }

    public void updateUser(Integer id ,User user) {
User u = userRepository.findUserById(id);
if(u == null) {
    throw new ApiException("User not found");
}

u.setUserName(user.getUserName());
u.setEmail(user.getEmail());
u.setPassword(user.getPassword());
userRepository.save(u);

    }

    public void deleteUser(Integer id) {
User u = userRepository.findUserById(id);
if(u == null) {
    throw new ApiException("User not found");
}
userRepository.delete(u);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsersBeforeRegistrationDate(LocalDate date) {
        return userRepository.findAllByRegistrationDateBefore(date);
    }





















}
