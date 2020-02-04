package ru.cft.shift.repetito.repository;

import ru.cft.shift.repetito.entity.TokenEntity;
import ru.cft.shift.repetito.entity.UserEntity;

import java.util.UUID;

public interface TokenRepository {
    UserEntity getUserByToken(UUID token);

    TokenEntity createOrUpdateEntity(TokenEntity tokenEntity);
}
