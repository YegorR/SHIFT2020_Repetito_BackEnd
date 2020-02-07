package ru.cft.shift.repetito.service;

import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.params.response.UserFullResponse;
import ru.cft.shift.repetito.params.response.UserSimpleResponse;

import java.util.List;

public interface UserService {
    UserFullResponse register(UserEntity user);

    UserEntity getUserById(Long id);

    List<UserSimpleResponse> getUserList(UserFilter userFilter);

    UserFullResponse editUser(UserEntity user);

    UserEntity getUserByEmailAndPassword(String email, String password);

    boolean deleteUser(Long id);

}
