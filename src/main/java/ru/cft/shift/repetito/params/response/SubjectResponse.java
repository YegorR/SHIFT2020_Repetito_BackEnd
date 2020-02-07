package ru.cft.shift.repetito.params.response;

import ru.cft.shift.repetito.entity.SubjectEntity;

public class SubjectResponse {
    private Long id;
    private String name;

    public SubjectResponse(SubjectEntity subject) {
        this.id = subject.getId();
        this.name = subject.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
