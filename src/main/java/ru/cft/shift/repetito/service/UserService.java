package ru.cft.shift.repetito.service;

import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.entity.response.UserFullResponse;
import ru.cft.shift.repetito.entity.response.UserSimpleResponse;

import java.util.List;

public interface UserService {
    UserFullResponse get(Long id);
    List<UserSimpleResponse> get(boolean onlyTeacher, String faculty, int course, List<String> subject, String degree, String search, int limit, int offset);
    UserEntity add(UserEntity user);
    UserEntity edit(UserEntity user);
    void delete(Long id);
}
