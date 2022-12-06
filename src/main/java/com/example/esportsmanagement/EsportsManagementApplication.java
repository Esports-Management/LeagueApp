package com.example.esportsmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class EsportsManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsportsManagementApplication.class, args);
    }

}
