package ru.cft.shift.repetito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shift.repetito.entity.SubjectEntity;
import ru.cft.shift.repetito.params.response.SubjectResponse;
import ru.cft.shift.repetito.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Override
    public List<SubjectResponse> getAllSubjects(){
        List<SubjectEntity> subjects = subjectRepository.findAll();
        List<SubjectResponse> subjectResponse = new ArrayList<>();
        for (SubjectEntity r:subjects)
            subjectResponse.add(new SubjectResponse(r));
        return subjectResponse;
    }

    @Override
    public SubjectEntity getSubjectById(Long id){
        Optional<SubjectEntity> subjectEntityOptional = subjectRepository.findById(id);
        if (subjectEntityOptional.isPresent())
            return subjectEntityOptional.get();
        else return null;
    }
}
