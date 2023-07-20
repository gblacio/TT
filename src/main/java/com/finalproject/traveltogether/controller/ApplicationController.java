package com.finalproject.traveltogether.controller;

import com.finalproject.traveltogether.configuration.PasswordEncoder;
import com.finalproject.traveltogether.entity.User;
import com.finalproject.traveltogether.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Controller
@Slf4j
public class ApplicationController {

    @Autowired
    private UserService userService;
    private final PasswordEncoder passwordEncoder = new PasswordEncoder();

    @GetMapping("/")
    public String showHome(){
        return "redirect:/travelers";
    }

    @GetMapping("/travelers")
    public String showHomePage(){
        return "indexTraveler";
    }

    @GetMapping("/travelers/register")
    public String showRegisterTraveler(Model model){//If there is no new user object, the page of register, we will not be able to add any attributes later on.
        model.addAttribute("user", new User()); // Add the "user" object to the model
        return "registerTravelers";
    }

   @PostMapping("/travelers/register/save")
    public String saveUser(@Valid User user, RedirectAttributes redirectAttributes, Errors error, Model model){
       if  (!isValidEmail(user.getEmail())) {
           error.rejectValue("email", "InvalidEmail", "The email is already in use");
           model.addAttribute("user", user);
           return "registerTravelers";
       }

       if  (!isValidPhoneNumber(user.getPhone())) {
           error.rejectValue("phone", "InvalidPhone", "Your phone number is not valid");
            model.addAttribute("user", user);
            return "registerTravelers";
      }

       if (!isValidBirthDate(user.getDateOfBirth())) {
           error.rejectValue("dateOfBirth", "InvalidAge", "You must be at least 18 years old.");
           model.addAttribute("user", user);
           return "registerTravelers";
       }

       String encodedPassword = passwordEncoder.encode(user.getUserPassword());
       user.setUserPassword(encodedPassword);
       user.setRoleID(1);
       user.setGenderID(3);
       userService.saveUser(user);
      // return "redirect:/travelers/login?success=true";
       redirectAttributes.addFlashAttribute("success", true);
       return "redirect:/travelers/login";
    }

    private boolean isValidPhoneNumber(String phone) {
        Long phoneNumber;
        try {
            phoneNumber = Long.parseLong(phone);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        User existingUser = userService.findUserByEmail(email); // Check if the email already exists in the database
        return existingUser == null; //returns true, if the email doesn't exist in the db
    }

    private boolean isValidBirthDate(Date date) {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = date.toLocalDate(); // Convert Date to LocalDate
        long age = ChronoUnit.YEARS.between(birthDate, currentDate);
        return age >= 18;
    }

    @GetMapping("/travelers/login")
    public String showLoginPage(Model model) {
        if (model.containsAttribute("success")) {// If it's present, pass it to the login page
            model.addAttribute("success", true);
        }
        return "LoginTraveler";
    }

    @PostMapping("/travelers/home")
    public String processLogin(@RequestParam String email, @RequestParam String userPassword, Model model) {
        User foundUser = userService.findUserByEmail(email);
        if (foundUser != null && passwordEncoder.verify(userPassword,foundUser.getUserPassword())){
             if (foundUser.getRoleID() == 1){
                 return "travelers";
             }
             else{
                 return "travelerserror";
             }

        } else {
            // If the credentials are invalid, return to the login page with an error message
            model.addAttribute("error", "Invalid credentials. Please try again.");
            return "LoginTraveler";
        }
    }
}
