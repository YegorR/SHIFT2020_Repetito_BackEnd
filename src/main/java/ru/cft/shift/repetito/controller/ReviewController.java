package ru.cft.shift.repetito.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user/{id}/review")
public class ReviewController {
    public void getList(@PathVariable int id) {

    }
}
