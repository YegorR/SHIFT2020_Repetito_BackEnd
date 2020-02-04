package ru.cft.shift.repetito.repository;

import ru.cft.shift.repetito.entity.User;
import ru.cft.shift.repetito.service.UserCriteria;

import java.util.List;

public interface UserRepository {
    List<User> findUsers(UserCriteria userCriteria);

    User findUserById(long id);

    User updateUser(User user);

    void deleteUserById(long id);

    User createUser(User user);
}
