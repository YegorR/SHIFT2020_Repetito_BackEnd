package ru.cft.shift.repetito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.shift.repetito.entity.TokenEntity;
import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.exception.AccessIsForbiddenException;
import ru.cft.shift.repetito.exception.NotAuthorisedException;
import ru.cft.shift.repetito.params.response.UserFullResponse;
import ru.cft.shift.repetito.params.request.UserParamsRequest;
import ru.cft.shift.repetito.service.TokenService;
import ru.cft.shift.repetito.service.UserFilter;
import ru.cft.shift.repetito.service.UserService;

import java.util.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = "application/json"
    )
    //получить список пользователей по фильтру
    public ResponseEntity<?> getList(
            @RequestParam(name = "isTeacher", defaultValue = "false") Boolean isTeacher,
            @RequestParam(name = "faculty", defaultValue = "null") String faculty,
            @RequestParam(name = "course", defaultValue = "0") long course,
            @RequestParam(name = "subject", defaultValue = "null") List<String> subject,
            @RequestParam(name = "degree", defaultValue = "null") String degree,
            @RequestParam(name = "search", defaultValue = "null") String search,
            @RequestParam(name = "limit", defaultValue = "10") int limit,
            @RequestParam(name = "offset", defaultValue = "0") int offset
    ) {
        UserFilter userFilter = new UserFilter();
        userFilter.setTeacher(isTeacher);
        userFilter.setFaculty(faculty);
        userFilter.setCourse(course);
        userFilter.setSubject(subject);
        userFilter.setDegree(degree);
        userFilter.setAbout(search);
        userFilter.setLimit(limit);
        userFilter.setOffset(offset);
        return ResponseEntity.ok(userService.getUserList(userFilter));
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}",
            produces = "application/json"
    )
    //получить данные пользователя
    public ResponseEntity<?> get(@PathVariable(name = "id") Long id,
                                 @RequestHeader(name = "Authorization", required = false) UUID uuid) throws NotAuthorisedException {
        if (tokenService.checkToken(uuid)) {
            UserFullResponse response = new UserFullResponse(userService.getUserById(id));
            return ResponseEntity.ok(response);
        } else throw new NotAuthorisedException();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    //зарегистрировать пользователя
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
    //метод изменения данных о пользователе
    public ResponseEntity<?> edit(@RequestBody UserParamsRequest userParamsRequest, @PathVariable(name = "id") Long id,
                                  @RequestHeader(name = "Authorization", required = false) UUID uuid) throws AccessIsForbiddenException {
        UserEntity userEditForm = new UserEntity(userParamsRequest);
        UserEntity userOfToken = tokenService.getUser(uuid);
        UserEntity userOfId = userService.getUserById(id);
        if (userOfToken != null && userOfId != null && userOfId == userOfToken){
            TokenEntity tokenEntity = userOfId.getToken();
            userEditForm.setId(id);
            tokenEntity.setUser(userEditForm);
            userEditForm.setToken(tokenEntity);
            return ResponseEntity.ok(userService.editUser(userEditForm));
        } else throw new AccessIsForbiddenException(uuid.toString());
    }

    @RequestMapping(
            method=RequestMethod.DELETE,
            path="/{id}",
            produces="application/json"
    )
    //Удаление пользователя
    public ResponseEntity<?> delete(@PathVariable(name="id") Long id,
                                      @RequestHeader (value = "Authorization", required = false) UUID uuid) throws AccessIsForbiddenException {
        UserEntity userOfToken =  tokenService.getUser(uuid);
        if (userOfToken != null && userOfToken.getId() == id) {
            return ResponseEntity.ok(userService.deleteUser(id));
        } else throw new AccessIsForbiddenException(uuid.toString());
    }
}
