package ru.cft.shift.repetito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shift.repetito.entity.UserEntity;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    UserService userService;
    @Autowired
    AuthenticationService authenticationService;

    public UserEntity login(String email, String password){
            return userService.getUserByEmailAndPassword(email, password);
    }

    public UserEntity logout(UserEntity userEntity){
        return null;
    }
}
