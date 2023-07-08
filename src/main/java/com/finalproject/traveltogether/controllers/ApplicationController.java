package com.finalproject.traveltogether.controllers;

import com.finalproject.traveltogether.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ApplicationController {

    @GetMapping("/profile")
    public String profile(User user){
        return "EditProfile";
    }
}
