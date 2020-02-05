package ru.cft.shift.repetito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.shift.repetito.params.UserParamsRequest;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    /*@RequestMapping(
            method = RequestMethod.GET,
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json"
    )
    public UserSimpleResponse getList(
            @RequestParam(name = "onlyTeacher", defaultValue = "false") boolean onlyTeacher,
            @RequestParam(name = "faculty", defaultValue = "null") String faculty,
            @RequestParam(name = "course", defaultValue = "null") int course,
            @RequestParam(name = "subject", defaultValue = "null") List<String> subject,
            @RequestParam(name = "degree", defaultValue = "null") String degree,
            @RequestParam(name = "search", defaultValue = "null") String search,
            @RequestParam(name = "limit", defaultValue = "10") int limit,
            @RequestParam(name = "offset", defaultValue = "0") int offset
    ) {
        return userService.get(onlyTeacher, faculty, course, subject, degree, search, limit, offset);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}",
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json"
    )
    public UserFullResponse get(@PathVariable(name = "id") Long id) {
        return userService.get(id);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public User add(@RequestBody UserParamsRequest userParamsRequest) {
        User user = new User(userParamsRequest);
        return userService.add(user);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            path = "/{id}",
            consumes = "application/json",
            produces = "application/json"
    )
    public User edit(@RequestBody UserParamsRequest userParamsRequest, @PathVariable(name = "id") Long id) {
        User user = new User(userParamsRequest);
        user.setId(id);
        return userService.edit(user);
    }
*/
}