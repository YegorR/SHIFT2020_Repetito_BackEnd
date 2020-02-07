package ru.cft.shift.repetito.service;

import org.springframework.stereotype.Service;
import ru.cft.shift.repetito.entity.SubjectEntity;
import ru.cft.shift.repetito.params.response.SubjectResponse;

import java.util.List;

public interface SubjectService {
    List<SubjectResponse> getAllSubjects();
    SubjectEntity getSubjectById(Long id);
}
