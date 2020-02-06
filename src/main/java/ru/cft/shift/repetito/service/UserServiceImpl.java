package ru.cft.shift.repetito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.params.response.UserFullResponse;
import ru.cft.shift.repetito.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity register(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserFullResponse getUserById(Long id){
        Optional<UserEntity> user = userRepository.findById(id);
        if (user!=null)
        return new UserFullResponse(user.get());
        else return null;
    }

    /*@Override
    public List<UserSimpleResponse> getUserList(boolean onlyTeacher, String faculty, int course, List<String> subject, String degree, String search, int limit, int offset) {
        List<UserSimpleResponse> userSimpleResponseList = new ArrayList<>();
        UserSpecification spec = new UserSpecification(new SearchCriteria("isTeacher", ":", onlyTeacher));
        List<UserEntity> users = userRepository.findAll(spec);
        for (UserEntity user: users) {
            userSimpleResponseList.add(new UserSimpleResponse(user));
        }
        return userSimpleResponseList;
    }*/

    @Override
    public UserEntity editUser(UserEntity user) {
        return register(user);
    }

    @Override
    public  UserEntity getUserByEmailAndPassword(String email, String password){
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public void deleteUser(Long id){
        Optional<UserEntity> user = userRepository.findById(id);
        if (user!=null)
        userRepository.delete(user.get());
    }
}
