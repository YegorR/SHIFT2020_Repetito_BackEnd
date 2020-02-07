package ru.cft.shift.repetito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.shift.repetito.entity.TokenEntity;
import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.params.request.LoginFormRequest;
import ru.cft.shift.repetito.params.response.LoginResultResponse;
import ru.cft.shift.repetito.params.response.UserFullResponse;
import ru.cft.shift.repetito.service.AuthenticationService;
import ru.cft.shift.repetito.service.TokenService;
import ru.cft.shift.repetito.service.UserService;
import java.util.UUID;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(
            path = "/login",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> login(@RequestBody LoginFormRequest loginFormRequest){
        TokenEntity tokenEntity = authenticationService.login(loginFormRequest.getEmail(), loginFormRequest.getPassword());
        LoginResultResponse loginResultResponse = new LoginResultResponse();
        if (tokenEntity != null) {
            loginResultResponse.setSuccessful(true);
            loginResultResponse.setUser(new UserFullResponse(tokenEntity.getUser()));
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
    public ResponseEntity<?> logout(@RequestHeader("Authorization") UUID uuid){
        if (authenticationService.logout(uuid))
            return ResponseEntity.ok().body("You've logged out");
        else return ResponseEntity.status(403).body("Forbidden");
    }
}
