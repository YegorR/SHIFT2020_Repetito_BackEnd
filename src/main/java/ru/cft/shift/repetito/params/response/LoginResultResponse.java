package ru.cft.shift.repetito.params.response;

import ru.cft.shift.repetito.entity.UserEntity;

import java.util.UUID;

public class LoginResultResponse {
    private boolean successful;

    private UUID uuid;

    private UserEntity user;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
