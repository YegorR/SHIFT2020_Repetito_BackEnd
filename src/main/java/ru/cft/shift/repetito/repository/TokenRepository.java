package ru.cft.shift.repetito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cft.shift.repetito.entity.TokenEntity;
import ru.cft.shift.repetito.entity.UserEntity;

import java.util.UUID;

public interface TokenRepository extends JpaRepository<TokenEntity, Long> {
    UserProjection findByUuid(UUID uuid);

    TokenEntity createOrUpdateEntity(TokenEntity tokenEntity);
}
