package ru.cft.shift.repetito.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.shift.repetito.service.SubjectService;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @RequestMapping(
            method= RequestMethod.GET,
            path="/subjects",
            produces = "application/json"
    ) public ResponseEntity<?> get() {
        return ResponseEntity.ok(subjectService.getAllSubjects());
    }
}
