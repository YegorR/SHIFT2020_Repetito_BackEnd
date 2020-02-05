package ru.cft.shift.repetito.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.shift.repetito.params.LoginFormRequest;
import ru.cft.shift.repetito.params.LoginResultResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @RequestMapping("")
    public LoginResultResponse login(LoginFormRequest loginFormRequest, HttpServletResponse response) {
        LoginResultResponse loginResultResponse = new LoginResultResponse();
        loginResultResponse.setSuccessful(true);
        response.addCookie(new Cookie("ACCESS_TOKEN", UUID.randomUUID().toString()));
        return loginResultResponse;
    }
}
