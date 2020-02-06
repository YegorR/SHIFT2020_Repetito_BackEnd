package ru.cft.shift.repetito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cft.shift.repetito.entity.TokenEntity;

import java.util.UUID;

public interface TokenRepository extends JpaRepository<TokenEntity, Long> {
    TokenEntity findByUuid(UUID uuid);

    Boolean existsByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);
}