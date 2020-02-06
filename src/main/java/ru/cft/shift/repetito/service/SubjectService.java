package ru.cft.shift.repetito.service;

import org.springframework.stereotype.Service;
import ru.cft.shift.repetito.entity.SubjectEntity;

import java.util.List;

@Service
public interface SubjectService {
    List<SubjectEntity> getAllSubjects();
}
