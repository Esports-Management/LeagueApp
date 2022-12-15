package com.example.esportsmanagement;

import com.example.esportsmanagement.web.controller.match.config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.esportsmanagement.user.jpa.data.ManageDatabase;
import com.example.esportsmanagement.user.jpa.data.UpdateDatabaseWithMatches;


@SpringBootApplication
public class EsportsManagementApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EsportsManagementApplication.class, args);

    }



}
