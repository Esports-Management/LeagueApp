package com.example.esportsmanagement.user.jpa.data.user;

import com.example.esportsmanagement.web.data.user.UserData;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    void register(final UserData user) throws Exception;
    boolean checkIfUserExist(final String email);
    void sendRegistrationConfirmationEmail(final UserEntity user);
    boolean verifyUser(final String token) throws Exception;
    UserEntity getUserById(final String id) throws Exception;
}
