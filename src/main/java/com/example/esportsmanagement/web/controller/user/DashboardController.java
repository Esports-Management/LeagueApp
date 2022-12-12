package com.example.esportsmanagement.web.controller.user;

import com.example.esportsmanagement.user.DefaultUserService;
import com.example.esportsmanagement.user.jpa.data.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class DashboardController {

    @GetMapping(value = "/dashboard")
    public String userDashboard() {

        return "/dashboard";
    }
}
