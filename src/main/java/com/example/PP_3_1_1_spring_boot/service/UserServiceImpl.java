package com.example.PP_3_1_1_spring_boot.service;

import com.example.PP_3_1_1_spring_boot.dao.UserDao;
import com.example.PP_3_1_1_spring_boot.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final
    UserDao userDAO;

    public UserServiceImpl(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.findById(id).orElseThrow(
                () -> new RuntimeException("Пользователя с таким ID не существует!!!"));
    }

    @Override
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Override
    public void updateUser(User updatedUser) {
        userDAO.save(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteById(id);
    }
}
