package ru.cft.shift.repetito.service.criteria;

import java.util.ArrayList;
import java.util.List;

public class UserCriteria {
    private boolean isTeacher;

    private List<String> faculty = new ArrayList<>();

    private List<Integer> course = new ArrayList<>();

    private List<String> subject = new ArrayList<>();

    private List<String> degree = new ArrayList<>();

    private String search = null;

    private int limit = 10;

    private int offset = 0;

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    public List<String> getFaculty() {
        return faculty;
    }

    public void setFaculty(List<String> faculty) {
        this.faculty = faculty;
    }

    public List<Integer> getCourse() {
        return course;
    }

    public void setCourse(List<Integer> course) {
        this.course = course;
    }

    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
    }

    public List<String> getDegree() {
        return degree;
    }

    public void setDegree(List<String> degree) {
        this.degree = degree;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
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
