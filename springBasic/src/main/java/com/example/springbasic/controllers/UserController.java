package com.example.springbasic.controllers;

import com.example.springbasic.model.Product;
import com.example.springbasic.model.User;
import com.example.springbasic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping ("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userServise) {
        this.userService = userServise;
    }

    @GetMapping("/show_all")
    public String usersAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/users";
    }
    @GetMapping("/{id}")
    public String userById(@PathVariable long id, Model model){
        model.addAttribute("user", userService.findById(id));
        return "users/user";
    }


}
