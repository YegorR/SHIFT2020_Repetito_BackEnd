package ru.cft.shift.repetito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.params.UserParamsRequest;
import ru.cft.shift.repetito.service.UserService;
import ru.cft.shift.repetito.entity.response.UserFullResponse;
import ru.cft.shift.repetito.entity.response.UserSimpleResponse;
import ru.cft.shift.repetito.params.UserJSONRequest;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(
            method=RequestMethod.GET,
            path="/user",
            consumes="application/x-www-form-urlencoded",
            produces="application/json"
    ) public List<UserSimpleResponse> get(@RequestParam UserParamsRequest userParamsRequest) {
        return userService.get(userParamsRequest);
    }

    @RequestMapping(
            method=RequestMethod.GET,
            path="/user/{id}",
            consumes = "application/x-www-form-urlencoded",
            produces="application/json"
    ) public UserFullResponse get(@PathVariable(name = "id") Long id) {
        return userService.get(id);
    }

    @RequestMapping(
            method=RequestMethod.POST,
            path="/user",
            consumes = "application/json",
            produces = "application/json"
    ) public UserEntity add(@RequestBody UserJSONRequest userJSONRequest) {
        UserEntity user  = new UserEntity(userJSONRequest);
        return userService.add(user);
    }

    @RequestMapping(
            method=RequestMethod.PUT,
            path="/user/{id}",
            consumes = "application/json",
            produces = "application/json"
    ) public UserEntity edit(@RequestBody UserJSONRequest userParamsRequest, @PathVariable (name="id") Long id){
        UserEntity user = new UserEntity(userParamsRequest);
        user.setId(id);
        return userService.edit(user);
    }

    @RequestMapping(
            method=RequestMethod.DELETE,
            path="/user/{id}",
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json"
    ) public UserEntity delete(@PathVariable (name="id") Long id){
        return userService.delete(id);
    }

}
