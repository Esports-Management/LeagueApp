package com.example.esportsmanagement.user;

import com.example.esportsmanagement.exceptions.EmailTakenException;
import com.example.esportsmanagement.exceptions.UserNameTakenException;
import com.example.esportsmanagement.user.jpa.data.UserEntity;
import com.example.esportsmanagement.user.jpa.data.UserService;
import com.example.esportsmanagement.user.jpa.repository.UserRepository;
import com.example.esportsmanagement.web.data.user.UserData;
import org.apache.catalina.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service("userService")
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void register(UserData user) throws EmailTakenException, UserNameTakenException {

        if(checkIfUserExist(user.getEmail())) {
            throw new EmailTakenException("User already exists for this email");
        }
        else if (checkIfUserNameExist(user.getUserName())) {
            throw new UserNameTakenException("This username is already taken");
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

    public boolean checkIfUserNameExist(String userName) {
        return userRepository.findByUserName(userName).isPresent();
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


    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not present"));
        return user;
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }

}
