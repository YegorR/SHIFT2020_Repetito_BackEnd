package ru.cft.shift.repetito.params;

import ru.cft.shift.repetito.entity.UserEntity;

import java.util.UUID;

public class LoginResultResponse {
    private boolean successful;

    private UUID uuid;

    private UserEntity userEntity;

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
