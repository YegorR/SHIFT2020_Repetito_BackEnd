package ru.cft.shift.repetito.service;

import ru.cft.shift.repetito.entity.TokenEntity;
import ru.cft.shift.repetito.entity.UserEntity;

import java.util.UUID;


public interface AuthenticationService {

    TokenEntity login(String email, String password);

    Boolean logout(UUID uuid);
}
