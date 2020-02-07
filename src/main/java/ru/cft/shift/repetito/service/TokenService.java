package ru.cft.shift.repetito.service;

import org.springframework.stereotype.Service;
import ru.cft.shift.repetito.entity.TokenEntity;
import ru.cft.shift.repetito.entity.UserEntity;

import java.util.UUID;

@Service
public interface TokenService {
    Boolean checkToken(UUID uuid);

    TokenEntity getNewToken(UserEntity userEntity);

    TokenEntity getTokenByUuid(UUID uuid);

    UserEntity getUser(UUID uuid);

    void deleteTokenByUuid(UUID uuid);

    void deleteTokenByUser(UserEntity userEntity);
}
