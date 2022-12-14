package com.example.esportsmanagement.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
<<<<<<< Updated upstream
                        .requestMatchers(
                                "/**"
                        ).permitAll()
=======
                        .requestMatchers("/", "/find", "/register","/css/style.css","/img/Aatroxfr.png"
                        ,"/img/teemo.jpeg","/img/Ashe.png","/css/forregistersuccess.css",
                                "/img/morgana2.jpg", "/img/kayle.jpg","/img/shen.jpg").permitAll()
>>>>>>> Stashed changes
                        .requestMatchers("/dashboard").hasRole("USER")
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}