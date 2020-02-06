package ru.cft.shift.repetito.service;

import ru.cft.shift.repetito.entity.TokenEntity;
import ru.cft.shift.repetito.entity.UserEntity;



public interface AuthenticationService {

    TokenEntity login(String email, String password);

    void logout(UserEntity userEntity);

}
