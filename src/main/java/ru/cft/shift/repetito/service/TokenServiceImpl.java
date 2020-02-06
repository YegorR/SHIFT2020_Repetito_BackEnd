package ru.cft.shift.repetito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cft.shift.repetito.entity.TokenEntity;
import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.repository.TokenRepository;
import ru.cft.shift.repetito.repository.UserProjection;

import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService{

    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private UserService userService;

    @Override
    public TokenEntity getToken(UserEntity userEntity){
        TokenEntity tokenEntity = new TokenEntity();
        //tokenRepository.save(tokenEntity);
        tokenEntity.setUser(userEntity);
        tokenEntity.setUuid(UUID.randomUUID());
        //userEntity.setToken(tokenEntity);
        tokenRepository.save(tokenEntity);
        userService.editUser(userEntity);
        return tokenEntity;
    }

    @Override
    public Boolean checkToken(UUID uuid){
        return tokenRepository.existsByUuid(uuid);
    }

    @Override
    public UserEntity getUser(UUID uuid){
        UserProjection userProjection = tokenRepository.findByUuid(uuid);
        return userProjection.getUser();
    }

    @Override
    public void deleteByUuid(UUID uuid){
        tokenRepository.deleteByUuid(uuid);
    }

}
