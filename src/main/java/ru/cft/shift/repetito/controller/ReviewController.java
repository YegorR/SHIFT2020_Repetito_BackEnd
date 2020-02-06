package ru.cft.shift.repetito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.shift.repetito.entity.ReviewEntity;
import ru.cft.shift.repetito.service.ReviewService;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @RequestMapping(
            method=RequestMethod.GET,
            path="/user/{id}/review",
            produces = "application/json"
    ) public ResponseEntity<?> get(@PathVariable (name="id") Long id) {
        return ResponseEntity.ok(reviewService.get(id));
    }

    /*@RequestMapping(
            method=RequestMethod.POST,
            path="/user/{id}/review",
            consumes="application/json",
            produces="application/json"
    ) public ResponseEntity<?> add(
            @RequestParam (name="mark") int mark,
            @RequestParam (name="comment") String comment,
            @PathVariable (name="id") Long id
    ) {
        ReviewEntity review = new ReviewEntity(id, mark, comment,  );
        return ResponseEntity<?>.ok(reviewService.add(review));
    }

     */
}
