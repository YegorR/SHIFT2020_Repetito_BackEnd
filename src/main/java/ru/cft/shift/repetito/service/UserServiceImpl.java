package ru.cft.shift.repetito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.entity.response.UserFullResponse;
import ru.cft.shift.repetito.entity.response.UserSimpleResponse;
import ru.cft.shift.repetito.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity add(UserEntity user) {
        return userRepository.save(user);
    }

    public UserFullResponse get(Long id){
        Optional<UserEntity> user = userRepository.findById(id);
        if (user!=null)
        return new UserFullResponse(user.get());
    }

    public List<UserSimpleResponse> get(boolean onlyTeacher, String faculty, int course, List<String> subject, String degree, String search, int limit, int offset) {
        List<UserEntity> userEntityList = userRepository.findUsers(onlyTeacher, faculty, course, subject, degree, search, limit, offset);
        List<UserSimpleResponse> userSimpleResponseList = null;
        for (UserEntity user: userEntityList) {
            userSimpleResponseList.add(new UserSimpleResponse(user));
        }
        return userSimpleResponseList;
    }

    public UserEntity edit(UserEntity user) {
        add(user);
    }

    public void delete(Long id){
        Optional<UserEntity> user = userRepository.findById(id);
        if (user!=null)
        userRepository.delete(user.get());
    }
}
