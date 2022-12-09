package com.example.esportsmanagement;

import com.example.esportsmanagement.web.controller.user.RegistrationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class EsportsManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsportsManagementApplication.class, args);
    }

}
