package ru.cft.shift.repetito.params.request;

public class LoginFormRequest {
    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String login) {
        this.email = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
