package com.example.esportsmanagement.web.controller.user;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {

        @Autowired private SecurityUserDetailsService userDetailsService;
        @Autowired private PasswordEncoder passwordEncoder;
        @Autowired private UserRepository userRepository;
        @Override
        public Authentication authenticate(Authentication authentication)
                throws AuthenticationException {
            String username = authentication.getName();
            Optional<Attempts>
                    userAttempts = attemptsRepository.findAttemptsByUsername(username);
            if (userAttempts.isPresent()) {
                Attempts attempts = userAttempts.get();
                attempts.setAttempts(0); attemptsRepository.save(attempts);
            }
        }

        @Override public boolean supports(Class<?> authentication) {
            return true;
        }
}
