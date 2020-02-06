package ru.cft.shift.repetito.params.request;

public class ReviewRequest {
    public int mark;

    public String comment;

    public Long reviewer_id;

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

    public Long getReviewer_id() {
        return reviewer_id;
    }

    public void setReviewer_id(Long reviewer_id) {
        this.reviewer_id = reviewer_id;
    }
}
