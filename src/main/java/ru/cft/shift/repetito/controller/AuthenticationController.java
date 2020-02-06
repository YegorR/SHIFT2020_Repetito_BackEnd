package ru.cft.shift.repetito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.shift.repetito.entity.TokenEntity;
import ru.cft.shift.repetito.params.request.LoginFormRequest;
import ru.cft.shift.repetito.params.response.LoginResultResponse;
import ru.cft.shift.repetito.service.AuthenticationService;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping("")
    public LoginResultResponse login(@RequestBody LoginFormRequest loginFormRequest, HttpServletResponse httpServletResponse) throws IOException {
        TokenEntity tokenEntity = authenticationService.login(loginFormRequest.getEmail(), loginFormRequest.getPassword());
        if (tokenEntity != null) {
            LoginResultResponse loginResultResponse = new LoginResultResponse();
            loginResultResponse.setSuccessful(true);
            loginResultResponse.setUserEntity(tokenEntity.getUser());
            loginResultResponse.setUuid(tokenEntity.getUuid());
            return loginResultResponse;
        } else {
            httpServletResponse.sendError(406, "Email or Password are wrong");
            return null;
        }
    }
}
