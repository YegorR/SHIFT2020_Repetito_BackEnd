package ru.cft.shift.repetito.service;

import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.entity.response.UserFullResponse;
import ru.cft.shift.repetito.entity.response.UserSimpleResponse;

import java.util.List;

public interface UserService {
    UserEntity register(UserEntity user);

    UserFullResponse getUserById(Long id);

    /*List<UserSimpleResponse> getUserList(boolean onlyTeacher, String faculty, int course, List<String> subject, String degree, String search, int limit, int offset);*/

    UserEntity editUser(UserEntity user);

    UserEntity getUserByEmailAndPassword(String email, String password);

    void deleteUser(Long id);

}
