package ru.cft.shift.repetito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.shift.repetito.entity.TokenEntity;
import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.params.request.LoginFormRequest;
import ru.cft.shift.repetito.params.response.LoginResultResponse;
import ru.cft.shift.repetito.service.AuthenticationService;
import ru.cft.shift.repetito.service.TokenService;
import ru.cft.shift.repetito.service.UserService;
import java.util.UUID;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(
            path = "/login",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> login(@RequestBody LoginFormRequest loginFormRequest){
        TokenEntity tokenEntity = authenticationService.login(loginFormRequest.getEmail(), loginFormRequest.getPassword());
        LoginResultResponse loginResultResponse = new LoginResultResponse();
        if (tokenEntity != null) {
            loginResultResponse.setSuccessful(true);
            loginResultResponse.setUser(tokenEntity.getUser());
            loginResultResponse.setUuid(tokenEntity.getUuid());
        } else {
            loginResultResponse.setSuccessful(false);
            loginResultResponse.setUser(null);
            loginResultResponse.setUuid(null);
        }
        return ResponseEntity.ok(loginResultResponse);
    }
    @RequestMapping(
            path = "/logout",
            method = RequestMethod.POST
    )
    public void logout(@RequestHeader("Authorization") UUID uuid){
        authenticationService.logout(uuid);
    }
}
