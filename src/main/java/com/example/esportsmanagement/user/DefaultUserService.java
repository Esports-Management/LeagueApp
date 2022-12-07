package com.example.esportsmanagement.user;

import com.example.esportsmanagement.exceptions.EmailTakenException;
import com.example.esportsmanagement.exceptions.NickNameTakenException;
import com.example.esportsmanagement.user.jpa.data.UserEntity;
import com.example.esportsmanagement.user.jpa.data.UserService;
import com.example.esportsmanagement.user.jpa.repository.UserRepository;
import com.example.esportsmanagement.web.data.user.UserData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service("userService")
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void register(UserData user) throws EmailTakenException, NickNameTakenException {

        if(checkIfUserExist(user.getEmail())) {
            throw new EmailTakenException("User already exists for this email");
        }
        else if (checkIfNickNameExist(user.getNickName())) {
            throw new NickNameTakenException("This nickname is already taken");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(userEntity, user);
        userRepository.save(userEntity);
    }


    @Override
    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public boolean checkIfNickNameExist(String nickName) {
        return userRepository.findByNickName(nickName).isPresent();
    }

    @Override
    public void sendRegistrationConfirmationEmail(UserEntity user) {

    }

    @Override
    public boolean verifyUser(String token) throws Exception {
        return false;
    }

    @Override
    public UserEntity getUserById(String id) throws Exception {
        return null;
    }

    private void encodePassword(UserEntity userEntity, UserData user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userEntity.setPassword(encoder.encode(user.getPassword()));
    }

}
