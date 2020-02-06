package ru.cft.shift.repetito.service;

import ru.cft.shift.repetito.entity.UserEntity;



public interface AuthenticationService {

    UserEntity login(String email, String password);

    UserEntity logout(UserEntity userEntity);

}
