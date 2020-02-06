package ru.cft.shift.repetito.entity.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.cft.shift.repetito.entity.UserEntity;

import java.util.List;

public class UserFullResponse {
    public UserFullResponse(UserEntity user){
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.paronym = user.getParonym();
        this.faculty = user.getFaculty();
        this.course = user.getCourse();
        this.degree = user.getDegree();
        this.about = user.getAbout();
        this.isTeacher=user.getIsTeacher();
    }
    private Long id;
    private String firstName;
    private String lastName;
    private String paronym;
    private String faculty;
    private int course;
    private List<String> subjects;
    private String degree;
    private String about;
    private Boolean isTeacher;

    public Boolean getIsTeacher() {
        return isTeacher;
    }

    public void setIsTeacher(Boolean teacher) {
        isTeacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getParonym() {
        return paronym;
    }

    public void setParonym(String paronym) {
        this.paronym = paronym;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
