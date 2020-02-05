package ru.cft.shift.repetito.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class TokenEntity {
    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private UUID uuid;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
