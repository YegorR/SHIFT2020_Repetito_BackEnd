package ru.cft.shift.repetito.service;

import java.util.List;

public class UserFilter {
    private List<String> faculty;

    private List<Integer> courses;

    private List<String> subject;

    private String degree;

    private String about;

    private boolean isTeacher;

    private int limit;

    private int offset;

    public List<String> getFaculty() {
        return faculty;
    }

    public void setFaculty(List<String> faculty) {
        this.faculty = faculty;
    }

    public List<Integer> getCourses() {
        return courses;
    }

    public void setCourses(List<Integer> courses) {
        this.courses = courses;
    }

    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
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

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
