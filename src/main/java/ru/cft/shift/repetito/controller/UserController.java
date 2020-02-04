package ru.cft.shift.repetito.controller;

import org.springframework.web.bind.annotation.*;
import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.entity.response.UserFullResponse;
import ru.cft.shift.repetito.entity.response.UserSimpleResponse;
import ru.cft.shift.repetito.params.UserParamsRequest;

import java.util.List;

@RestController
public class UserController {

    @RequestMapping(
            method=RequestMethod.GET,
            path="/user",
            consumes="application/x-www-form-urlencoded",
            produces="application/json"
    ) public UserSimpleResponse get (
            @RequestParam (name = "onlyTeacher", defaultValue = "false") boolean onlyTeacher,
            @RequestParam (name = "faculty", defaultValue = "null") String faculty,
            @RequestParam (name = "course", defaultValue = "null") int course,
            @RequestParam (name= "subject", defaultValue = "null") List<String> subject,
            @RequestParam (name="degree", defaultValue = "null") String degree,
            @RequestParam (name = "search", defaultValue = "null") String search,
            @RequestParam (name = "limit", defaultValue = "10") int limit,
            @RequestParam (name = "offset", defaultValue = "0") int offset
            ) {
        return userService.get(onlyTeacher, faculty, course, subject, degree, search, limit, offset);
    }

    @RequestMapping(
            method=RequestMethod.GET,
            path="/user/{id}",
            consumes = "application/x-www-form-urlencoded",
            produces="application/json"
    ) public UserFullResponse get (@PathVariable(name = "id") Long id) {
        return userService.get(id);
    }

    @RequestMapping(
            method=RequestMethod.POST,
            path="/user",
            consumes = "application/json",
            produces = "application/json"
    ) public UserEntity add(@RequestBody UserParamsRequest userParamsRequest) {
        UserEntity user  = new UserEntity(userParamsRequest);
        return userService.add(user);
    }

    @RequestMapping(
            method=RequestMethod.PUT,
            path="/user/{id}",
            consumes = "application/json",
            produces = "application/json"
    ) public UserEntity edit(@RequestBody UserParamsRequest userParamsRequest, @PathVariable (name="id") Long id){
        UserEntity user = new UserEntity(userParamsRequest);
        user.setId(id);
        return userService.edit(user);
    }

}
