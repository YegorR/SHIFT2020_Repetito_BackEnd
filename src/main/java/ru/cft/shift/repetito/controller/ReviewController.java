package ru.cft.shift.repetito.controller;

import org.springframework.web.bind.annotation.*;
import ru.cft.shift.repetito.entity.ReviewEntity;

@RestController
public class ReviewController {

    @RequestMapping(
            method=RequestMethod.GET,
            path="/user/{id}/review",
            consumes="application/x-www-form-urlencoded",
            produces = "application/json"
    ) public ReviewEntity get(@PathVariable (name="id") Long id) {
        return reviewService.get(id);
    }

    @RequestMapping(
            method=RequestMethod.POST,
            path="/user/{id}/review",
            consumes="application/json",
            produces="application/json"
    ) public ReviewEntity add(
            @RequestParam (name="mark") int mark,
            @RequestParam (name="comment") String comment,
            @PathVariable (name="id") Long id
                              ) {
        ReviewEntity review = new ReviewEntity(id, mark, comment,  );
        return reviewService.add(review);
    }
}
