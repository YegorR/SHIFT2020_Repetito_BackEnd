package ru.cft.shift.repetito.repository;

import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.params.UserParamsRequest;

import java.util.List;

public interface UserRepository {
    List<UserEntity> findUsers(UserParamsRequest userParamsRequest);

    UserEntity findUserById(long id);

    UserEntity updateUser(UserEntity user);

    void deleteUserById(long id);

    UserEntity createUser(UserEntity user);
}
