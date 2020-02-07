package ru.cft.shift.repetito.params.response;

import ru.cft.shift.repetito.entity.UserEntity;

import java.util.List;

public class UserFullResponse {
    public UserFullResponse(UserEntity user) {
        this.email = user.getEmail();
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.patronymic = user.getPatronymic();
        this.faculty = user.getFaculty();
        this.course = user.getCourse();
        this.degree = user.getDegree();
        this.about = user.getAbout();
        this.isTeacher = user.getTeacher();
        this.price = user.getPrice();
        this.avgMark = user.getAvgMark();
    }

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String faculty;
    private int course;
    private String degree;
    private String about;
    private Boolean isTeacher;
    private int price;
    private float avgMark;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }
}
