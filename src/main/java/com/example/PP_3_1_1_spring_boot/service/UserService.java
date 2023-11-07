package com.example.PP_3_1_1_spring_boot.service;

import com.example.PP_3_1_1_spring_boot.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    void saveUser(User user);

    void updateUser(User updatedUser);

    void deleteUser(Long id);
}
