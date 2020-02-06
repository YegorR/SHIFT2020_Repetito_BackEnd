package ru.cft.shift.repetito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @RequestMapping("/login")
    public ResponseEntity login(@RequestBody LoginFormRequest loginFormRequest){
        TokenEntity tokenEntity = authenticationService.login(loginFormRequest.getEmail(), loginFormRequest.getPassword());
        if (tokenEntity != null) {
            LoginResultResponse loginResultResponse = new LoginResultResponse();
            loginResultResponse.setSuccessful(true);
            loginResultResponse.setUserEntity(tokenEntity.getUser());
            loginResultResponse.setUuid(tokenEntity.getUuid());
            return new ResponseEntity<LoginResultResponse>(loginResultResponse, HttpStatus.OK);
        } else {
            return ResponseEntity.ok(loginFormRequest);
        }
    }
    @RequestMapping("/logout")
    public void logout(@RequestHeader("Authorization") UUID uuid){
        UserEntity userEntity = tokenService.getUser(uuid);
        authenticationService.logout(userEntity);
    }
}
