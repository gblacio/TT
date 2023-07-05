package com.finalproject.traveltogether.controllers;

import com.finalproject.traveltogether.pojo.User;
import com.finalproject.traveltogether.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String start(Model model){
        var users = userService.userList();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/add")
    public String add(User user){
        return "profile";
    }

    @PostMapping("/save")
    public String save(User user){
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{userID}")
    public String edit(User user, Model model){
        user = userService.findUser(user);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/delete/{userID}")
    public String delete(User user){
        userService.delete(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete2(User user){
        userService.delete(user);
        return "redirect:/";
    }
}
