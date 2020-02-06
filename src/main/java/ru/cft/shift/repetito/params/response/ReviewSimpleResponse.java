package ru.cft.shift.repetito.params.response;

import ru.cft.shift.repetito.entity.ReviewEntity;

import java.util.List;

public class ReviewSimpleResponse {
    private int mark;
    private String comment;
    private Long teacher_id;
    private UserFullResponse reviewer;

    public ReviewSimpleResponse(ReviewEntity reviewer) {
        this.mark=reviewer.getMark();
        this.comment=reviewer.getComment();
        this.teacher_id=reviewer.getTeacher().getId();
        this.reviewer= new UserFullResponse(reviewer.getReviewer());
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public UserFullResponse getReviewer() {
        return reviewer;
    }

    public void setReviewer(UserFullResponse reviewer) {
        this.reviewer = reviewer;
    }
}
