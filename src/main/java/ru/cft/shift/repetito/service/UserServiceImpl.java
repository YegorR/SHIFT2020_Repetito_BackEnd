package ru.cft.shift.repetito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.params.response.UserFullResponse;
import ru.cft.shift.repetito.params.response.UserSimpleResponse;
import ru.cft.shift.repetito.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserFullResponse register(UserEntity user) {
        userRepository.save(user);
        return new UserFullResponse(user);
    }

    @Override
    public UserEntity getUserById(Long id){
        Optional<UserEntity> userOptional = userRepository.findById(id);
        return userOptional.get();
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
    public List<UserSimpleResponse> getUserList(UserFilter userFilter) {
        OffsetBasedPageRequest pageable = new OffsetBasedPageRequest(userFilter.getOffset(), userFilter.getLimit());
        List<UserEntity> users = userRepository.findByFilters(userFilter.getAbout(), userFilter.getCourse(), userFilter.getFaculty(), userFilter.getDegree(), userFilter.isTeacher(), userFilter.getSubject(), pageable);
        List<UserSimpleResponse> userResponse = new ArrayList<>();
        for (UserEntity u: users)
            userResponse.add(new UserSimpleResponse(u));
        return userResponse;
    }

    @Override
    public UserFullResponse editUser(UserEntity user) {
        return register(user);
    }

    @Override
    public  UserEntity getUserByEmailAndPassword(String email, String password){
        Optional<UserEntity> user = userRepository.findByEmailAndPassword(email, password);
        return user.orElse(null);
    }

    @Override
    public boolean deleteUser(Long id){
        userRepository.deleteById(id);
        return true;
    }
}
