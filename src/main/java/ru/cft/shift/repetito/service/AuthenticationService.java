package ru.cft.shift.repetito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.repository.UserRepository;

@Service
public interface AuthenticationService {

    UserEntity login(String email, String password);

    UserEntity logout(UserEntity userEntity);

}
