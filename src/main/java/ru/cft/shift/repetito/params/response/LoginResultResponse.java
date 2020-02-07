package ru.cft.shift.repetito.params.response;

import java.util.UUID;

public class LoginResultResponse {
    private boolean successful;

    private UUID token;

    private UserFullResponse user;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public UserFullResponse getUser() {
        return user;
    }

    public void setUser(UserFullResponse user) {
        this.user = user;
    }
}
