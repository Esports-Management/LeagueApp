package com.example.esportsmanagement;

import com.example.esportsmanagement.user.jpa.data.UserEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class EsportsManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsportsManagementApplication.class, args);
    }

}
