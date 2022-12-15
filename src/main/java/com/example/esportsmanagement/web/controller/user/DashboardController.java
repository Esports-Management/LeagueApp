package com.example.esportsmanagement.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping(value = "/dashboard")
    public String userDashboard() {

        return "/dashboard";
    }
}
