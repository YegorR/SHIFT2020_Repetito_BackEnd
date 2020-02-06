package ru.cft.shift.repetito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.shift.repetito.entity.TokenEntity;
import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.params.LoginFormRequest;
import ru.cft.shift.repetito.params.LoginResultResponse;
import ru.cft.shift.repetito.service.AuthenticationService;
import ru.cft.shift.repetito.service.TokenService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    TokenService tokenService;

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping("")
    public LoginResultResponse login(@RequestBody LoginFormRequest loginFormRequest, HttpServletResponse httpServletResponse) throws IOException {
        String password = loginFormRequest.getPassword();
        String email = loginFormRequest.getEmail();
        UserEntity userEntity = authenticationService.login(email, password);
        if (userEntity != null) {
            TokenEntity tokenEntity = tokenService.getToken(userEntity);
            LoginResultResponse loginResultResponse = new LoginResultResponse();
            loginResultResponse.setSuccessful(true);
            loginResultResponse.setUserEntity(userEntity);
            loginResultResponse.setUuid(tokenEntity.getUuid());
            return loginResultResponse;
        } else {
            httpServletResponse.sendError(406, "Email or Password are wrong");
            return null;
        }
    }
}
