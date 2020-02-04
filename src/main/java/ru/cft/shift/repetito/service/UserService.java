package ru.cft.shift.repetito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.entity.response.UserFullResponse;
import ru.cft.shift.repetito.entity.response.UserSimpleResponse;
import ru.cft.shift.repetito.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserFullResponse get(Long id)
    {
        return userRepository.findUserById(id);
    }

    @Override
    public List<UserSimpleResponse> get(boolean onlyTeacher, String faculty, int course, List<String> subject, String degree, String search, int limit, int offset)
    {
        return userRepository.findUsers(onlyTeacher, faculty, course, subject, degree, search, limit, offset);
    }

    @Override
    public UserEntity add(UserEntity user)
    {
        return userRepository.createUser(user);
    }

    @Override
    public UserEntity edit(UserEntity user)
    {

    }
}
