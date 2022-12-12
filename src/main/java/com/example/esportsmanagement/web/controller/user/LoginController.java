package com.example.esportsmanagement.web.controller.user;

import com.example.esportsmanagement.user.jpa.data.UserEntity;
import com.example.esportsmanagement.user.jpa.repository.UserRepository;
import com.example.esportsmanagement.web.data.user.UserData;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Controller
public class LoginController {


//    @GetMapping("/login")
//    public String login(){
//        return "/login";
//    }
//
//    private String getErrorMessage(HttpServletRequest request, String key) {
//        Exception exception = (Exception) request.getSession().getAttribute(key);
//        String error = "";
//        if (exception instanceof BadCredentialsException) {
//            error = "Invalid username and password!";
//        } else if (exception instanceof LockedException) {
//            error = exception.getMessage();
//        } else {
//            error = "Invalid username and password!";
//        }
//        return error;
//    }
//
//    @PostMapping("/login")
//    public String loginUser() throws Exception {
//        return "/home"; }

    @Autowired
    UserRepository userR;
    @GetMapping
    public String currentUser(@ModelAttribute("user") BindingResult result, Model model) {

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String userName = loggedInUser.getName();

        UserEntity user = userR.findByUserName(userName).get();
        String username1 = user.getUsername();
        model.addAttribute("firstName", username1);

        return "/home";

    }

    @GetMapping("/home")
    public String home(){
        return "/home";
    }


    @GetMapping("/dashboard")
    public String dashboard(){
        return "/dashboard";
    }
}
