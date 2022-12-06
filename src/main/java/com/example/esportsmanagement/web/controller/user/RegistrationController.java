package com.example.esportsmanagement.web.controller.user;

import com.example.esportsmanagement.user.jpa.data.UserService;
import com.example.esportsmanagement.web.data.user.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(final Model model){
        model.addAttribute("userData", new UserData());
        return "/register";
    }

    @PostMapping("/register")
    public String userRegistration(final @Valid  UserData userData, final BindingResult bindingResult, final Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("registrationForm", userData);
            return "/register";
        }
        try {
            userService.register(userData);
        }catch (Exception e){
            bindingResult.rejectValue("email", "userData.email","An account already exists for this email.");
            model.addAttribute("registrationForm", userData);
            return "/register";
        }
        return "/starter";
    }
}
