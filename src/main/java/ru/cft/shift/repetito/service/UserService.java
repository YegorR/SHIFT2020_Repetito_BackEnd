package ru.cft.shift.repetito.service;

import org.springframework.stereotype.Service;
import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.entity.response.UserFullResponse;
import ru.cft.shift.repetito.entity.response.UserSimpleResponse;
import ru.cft.shift.repetito.params.UserParamsRequest;
import ru.cft.shift.repetito.repository.UserRepository;

import java.util.List;

@Service
public class UserService{

    private UserRepository userRepository;

    public UserEntity add(UserEntity user) {
        return userRepository.createUser(user);
    }

    public UserFullResponse get(Long id){
        UserEntity user = userRepository.findUserById(id);
        return new UserFullResponse(user);
    }

    public List<UserSimpleResponse> get(UserParamsRequest userParamsRequest) {
        List<UserEntity> userEntityList = userRepository.findUsers(userParamsRequest);
        List<UserSimpleResponse> userSimpleResponseList = null;
        for (UserEntity user: userEntityList) {
            userSimpleResponseList.add(new UserSimpleResponse(user));
        }
        return userSimpleResponseList;
    }

    public UserEntity edit(UserEntity user) {
        return null;
    }
    
    public UserEntity delete(Long id){
        return null;
    }


}
