package ru.cft.shift.repetito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.shift.repetito.entity.TokenEntity;
import ru.cft.shift.repetito.exception.NotAuthorisedException;
import ru.cft.shift.repetito.params.request.LoginFormRequest;
import ru.cft.shift.repetito.params.response.LoginResultResponse;
import ru.cft.shift.repetito.params.response.UserFullResponse;
import ru.cft.shift.repetito.service.AuthenticationService;

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
            loginResultResponse.setToken(tokenEntity.getUuid());
        } else {
            loginResultResponse.setSuccessful(false);
            loginResultResponse.setUser(null);
            loginResultResponse.setToken(null);
        }
        return ResponseEntity.ok(loginResultResponse);
    }
    @RequestMapping(
            path = "/logout",
            method = RequestMethod.POST
    )
    public ResponseEntity<?> logout(@RequestHeader(name = "Authorization", required = false) UUID uuid) throws NotAuthorisedException {
        if (authenticationService.logout(uuid))
            return ResponseEntity.ok().body("You've logged out");
        else throw new NotAuthorisedException();
    }
}
