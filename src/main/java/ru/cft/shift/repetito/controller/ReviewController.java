package ru.cft.shift.repetito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.shift.repetito.entity.ReviewEntity;
import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.exception.NotAuthorisedException;
import ru.cft.shift.repetito.params.request.ReviewRequest;
import ru.cft.shift.repetito.service.ReviewService;
import ru.cft.shift.repetito.service.TokenService;
import ru.cft.shift.repetito.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @RequestMapping(
            method=RequestMethod.GET,
            path="/user/{id}/review",
            produces = "application/json"
    )
    //получить все обзоры на данного полльзователя
    public ResponseEntity<?> get(@PathVariable (name="id") Long id,
                                   @RequestHeader(name = "Authorization", required = false) UUID uuid) throws NotAuthorisedException {
        if (tokenService.checkToken(uuid))
            return ResponseEntity.ok(reviewService.get(id));
        else throw new NotAuthorisedException(uuid.toString());
    }

    @RequestMapping(
            method=RequestMethod.POST,
            path="/user/{id}/review",
            consumes="application/json",
            produces="application/json"
    )
    //создать обзор на пользователя
    public ResponseEntity<?> add(
            @RequestBody ReviewRequest reviewRequest,
            @PathVariable (name="id") Long id,
            @RequestHeader(name = "Authorization", required = false) UUID uuid) throws NotAuthorisedException {
        if (tokenService.checkToken(uuid)) {
            UserEntity user_teacher = userService.getUserById(id);
            UserEntity user_reviewer = tokenService.getUser(uuid);

            ReviewEntity review = new ReviewEntity();
            review.setComment(reviewRequest.getComment());
            review.setMark(reviewRequest.getMark());
            review.setReviewer(user_reviewer);
            review.setTeacher(user_teacher);
            return ResponseEntity.ok(reviewService.add(review));
        } else throw new NotAuthorisedException(uuid.toString());
    }
}
