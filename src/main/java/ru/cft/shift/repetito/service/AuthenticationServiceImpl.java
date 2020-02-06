package ru.cft.shift.repetito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shift.repetito.entity.TokenEntity;
import ru.cft.shift.repetito.entity.UserEntity;

import javax.persistence.OneToOne;
import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @Override
    public TokenEntity login(String email, String password){
            UserEntity userEntity = userService.getUserByEmailAndPassword(email, password);
            if (userEntity != null)
                return tokenService.getToken(userEntity);
            else
                return null;
    }

    @Override
    public void logout(UserEntity userEntity){
        userEntity.setToken(null);
        userService.editUser(userEntity);
        tokenService.deleteToken(userEntity.getToken().getUuid());
    }
}
