package ru.cft.shift.repetito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shift.repetito.entity.SubjectEntity;
import ru.cft.shift.repetito.repository.SubjectRepository;

import java.util.List;
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<SubjectEntity> getAllSubjects(){
        return subjectRepository.findAll();
    }
}
