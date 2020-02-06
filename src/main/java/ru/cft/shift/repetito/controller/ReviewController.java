package ru.cft.shift.repetito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.shift.repetito.entity.ReviewEntity;
import ru.cft.shift.repetito.entity.UserEntity;
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
    ) public ResponseEntity<?> get(@PathVariable (name="id") Long id) {
        return ResponseEntity.ok(reviewService.get(id));
    }

    @RequestMapping(
            method=RequestMethod.POST,
            path="/user/{id}/review",
            consumes="application/json",
            produces="application/json"
    ) public ResponseEntity<?> add(
            @RequestBody ReviewRequest reviewRequest,
            @PathVariable (name="id") Long id,
            @RequestHeader ("Authorization") UUID token
    ) {
        UserEntity user_teacher = userService.getUserById(id);
        UserEntity user_reviewer = tokenService.getUser(token);

        ReviewEntity review = new ReviewEntity();
        review.setComment(reviewRequest.getComment());
        review.setMark(reviewRequest.getMark());
        review.setReviewer(user_reviewer);
        review.setTeacher(user_teacher);
        return ResponseEntity.ok(reviewService.add(review));
    }
}
