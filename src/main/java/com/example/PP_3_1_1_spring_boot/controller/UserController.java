package com.example.PP_3_1_1_spring_boot.controller;

import com.example.PP_3_1_1_spring_boot.model.User;
import com.example.PP_3_1_1_spring_boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.validation.Valid;
import java.util.List;

@Controller
@Validated
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printWelcome(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/add_user")
    public String addUser(ModelMap model) {
        model.addAttribute("user", new User());
        return ("adduser");
    }

    @PostMapping
    public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Попытка создать пользователя без полей " + result.getAllErrors().toString());
            return "redirect:/error";
        }
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("edit_user")
    public String edit(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edituser";
    }

    @PostMapping("/save_edit_user")
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Попытка удалить поле у пользователя " + result.getAllErrors().toString());
            return "redirect:/error";
        }
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete_user")
    public String deleteUser(@RequestParam(value = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
    @GetMapping("/error")
    public String printError() {
        System.out.println("Oops  ");
        return ("error");
    }
}