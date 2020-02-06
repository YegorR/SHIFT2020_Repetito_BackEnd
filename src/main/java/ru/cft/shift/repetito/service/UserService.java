package ru.cft.shift.repetito.service;

import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.entity.response.UserFullResponse;
import ru.cft.shift.repetito.entity.response.UserSimpleResponse;

import java.util.List;

import java.util.List;

public interface UserService {
    UserEntity register(UserEntity user);

    UserEntity getUserById(Long id);

    List<UserEntity> getUserList(UserFilter userFilter);

    UserEntity editUser(UserEntity user);

    UserEntity getUserByEmailAndPassword(String email, String password);

    void deleteUser(Long id);

}
