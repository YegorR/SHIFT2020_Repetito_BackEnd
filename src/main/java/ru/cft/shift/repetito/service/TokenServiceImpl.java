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
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private UserService userService;

    @Override
    public TokenEntity getNewToken(UserEntity userEntity) {
        if (userEntity.getToken() != null) {
            deleteTokenByUser(userEntity);
            userEntity.setToken(null);
        }
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setUser(userEntity);
        tokenEntity.setUuid(UUID.randomUUID());
        userEntity.setToken(tokenEntity);
        userService.editUser(userEntity);
        return tokenEntity;
    }

    @Override
    public TokenEntity getTokenByUuid(UUID uuid){
        return tokenRepository.findByUuid(uuid);
    }

    @Override
    public Boolean checkToken(UUID uuid) {
        return tokenRepository.existsByUuid(uuid);
    }

    @Override
    public UserEntity getUser(UUID uuid) {
            if (checkToken(uuid))
                return tokenRepository.findByUuid(uuid).getUser();
            else return null;
    }

    @Override
    public void deleteTokenByUuid(UUID uuid) {
            deleteTokenByUser(getUser(uuid));
    }

    @Override
    public void deleteTokenByUser(UserEntity userEntity){
            Long id = userEntity.getToken().getId();
            userEntity.setToken(null);
            userService.editUser(userEntity);
            tokenRepository.deleteById(id);
    }

}
