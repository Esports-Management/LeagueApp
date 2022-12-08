package com.example.esportsmanagement.web.controller.user;

import com.example.esportsmanagement.exceptions.EmailTakenException;
import com.example.esportsmanagement.exceptions.NickNameTakenException;
import com.example.esportsmanagement.user.jpa.data.UserService;
import com.example.esportsmanagement.user.DefaultUserService;
import com.example.esportsmanagement.web.data.user.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private DefaultUserService defaultUserService;

    @GetMapping("/registrationSuccess")
    public String success() {
        return "/registrationSuccess";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("userData", new UserData());
        return "/register";
    }

    @PostMapping("/register")
    public String userRegistration(
            @Valid UserData userData,
            BindingResult bindingResult,
            Model model,
            @RequestParam("email") String email){
        System.out.println(userData.getEmail());
        if(bindingResult.hasErrors()){
            model.addAttribute("registrationForm", userData);
            return "/register";
        }
        try {
            defaultUserService.register(userData);
        }catch (NickNameTakenException e){
            System.out.println(e);
            bindingResult.rejectValue("nickName", "userData.nickName", e.getMessage());
            model.addAttribute("registrationForm", userData);
            return "/register";
        } catch (EmailTakenException e) {
            System.out.println(e);
            bindingResult.rejectValue("email", "userData.email", e.getMessage());
            model.addAttribute("registrationForm", userData);
            return "/register";
        }
        return "/registrationSuccess";
    }
}
