package ru.cft.shift.repetito.params.response;

import ru.cft.shift.repetito.entity.ReviewEntity;

public class ReviewFullResponse {
    private Long id;
    private int mark;
    private String comment;
    private UserFullResponse reviewer;
    private UserFullResponse repetitor;

    public ReviewFullResponse(ReviewEntity review) {
        this.id = review.getId();
        this.mark = review.getMark();
        this.comment = review.getComment();
        this.reviewer = new UserFullResponse(review.getReviewer());
        this.repetitor = new UserFullResponse(review.getTeacher());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserFullResponse getReviewer() {
        return reviewer;
    }

    public void setReviewer(UserFullResponse reviewer) {
        this.reviewer = reviewer;
    }

    public UserFullResponse getRepetitor() {
        return repetitor;
    }

    public void setRepetitor(UserFullResponse repetitor) {
        this.repetitor = repetitor;
    }
}
