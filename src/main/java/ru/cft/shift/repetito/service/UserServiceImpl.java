package ru.cft.shift.repetito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.entity.response.UserFullResponse;
import ru.cft.shift.repetito.entity.response.UserSimpleResponse;
import ru.cft.shift.repetito.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity register(UserEntity user) {
        return userRepository.createUser(user);
    }

    @Override
    public UserFullResponse getUserById(Long id){
        UserEntity user = userRepository.findUserById(id);
        return new UserFullResponse(user);
    }

    @Override
    public List<UserSimpleResponse> getUserList(boolean onlyTeacher, String faculty, int course, List<String> subject, String degree, String search, int limit, int offset) {
        List<UserEntity> userEntityList = userRepository.findUsers(onlyTeacher, faculty, course, subject, degree, search, limit, offset);
        List<UserSimpleResponse> userSimpleResponseList = null;
        for (UserEntity user: userEntityList) {
            userSimpleResponseList.add(new UserSimpleResponse(user));
        }
        return userSimpleResponseList;
    }

    @Override
    public UserEntity editUser(UserEntity user) {
        return null;
    }

    @Override
    public void deleteUser(Long id){

    }


}
