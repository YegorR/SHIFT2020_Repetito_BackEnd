package ru.cft.shift.repetito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.params.response.UserFullResponse;
import ru.cft.shift.repetito.params.response.UserSimpleResponse;
import ru.cft.shift.repetito.params.request.UserParamsRequest;
import ru.cft.shift.repetito.service.UserFilter;
import ru.cft.shift.repetito.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResponseEntity<?> getList(
            @RequestParam(name = "isTeacher", defaultValue = "false") Boolean isTeacher,
            @RequestParam(name = "faculty", defaultValue = "null") String faculty,
            @RequestParam(name = "course", defaultValue = "1") int course,
            @RequestParam(name = "subject", defaultValue = "null") List<String> subject,
            @RequestParam(name = "degree", defaultValue = "null") String degree,
            @RequestParam(name = "search", defaultValue = "null") String search,
            @RequestParam(name = "limit", defaultValue = "10") int limit,
            @RequestParam(name = "offset", defaultValue = "0") int offset
    ) {
        //return userService.getUserList(isTeacher, faculty, course, subject, degree, search, limit, offset);
        //return ResponseEntity.ok(new ArrayList<UserSimpleResponse>());
        UserFilter userFilter = new UserFilter();
        userFilter.setTeacher(isTeacher);
        userFilter.setFaculty(new ArrayList<>(Collections.singletonList(faculty)));
        userFilter.setCourses(new ArrayList<>(Collections.singletonList(course)));
        userFilter.setSubject(subject);
        userFilter.setDegree(degree);
        userFilter.setAbout(search);
        userFilter.setLimit(limit);
        userFilter.setOffset(offset);
        List<UserEntity> users = userService.getUserList(userFilter);
        return ResponseEntity.ok(users.stream()
                .map(UserSimpleResponse::new)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}",
            produces = "application/json"
    )
    public ResponseEntity<?> get(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<?> add(@RequestBody UserParamsRequest userParamsRequest) {
        UserEntity user = new UserEntity(userParamsRequest);
        return ResponseEntity.ok(userService.register(user));
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            path = "/{id}",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<?> edit(@RequestBody UserParamsRequest userParamsRequest, @PathVariable(name = "id") Long id) {
        UserEntity user = new UserEntity(userParamsRequest);
        user.setId(id);
        return ResponseEntity.ok(userService.editUser(user));
    }

    @RequestMapping(
            method=RequestMethod.DELETE,
            path="/{id}",
            produces="application/json"
    ) public ResponseEntity<?> delete(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
