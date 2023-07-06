package com.finalproject.traveltogether.controllers;

import com.finalproject.traveltogether.pojo.User;
import com.finalproject.traveltogether.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.Errors;

import javax.validation.Valid;

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
    public String save(@Valid User user, Errors errors){
        if (errors.hasErrors()){
            return "profile";
        }

        if (!isValidPhoneNumber(user.getPhone())) {
            errors.rejectValue("phone", "InvalidPhone", "Por favor, ingresa un número válido");
            return "profile";
        }

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

    private boolean isValidPhoneNumber(String phone) {
        // Realiza la validación adicional antes de la validación con expresiones regulares
        if (!NumberUtils.isCreatable(phone)) {
            return false;
        }

        // Verifica si el número contiene solo dígitos utilizando una expresión regular
        return phone.matches("\\d+");
    }
}
