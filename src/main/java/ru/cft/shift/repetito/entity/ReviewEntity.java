package ru.cft.shift.repetito.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Table(name="reviews")
public class ReviewEntity {
    @Id
    private Long id;

    @Column(name = "mark")
    private int mark;

    @Column(name = "comment")
    private String  comment;

    @Column(name = "reviewer_id")
    private Long reviewerId;

    @Column(name = "teacher_id")
    private  Long teacherId;

    public ReviewEntity(int mark, String comment, Long reviewerId, Long teacherId) {
        this.mark=mark;
        this.comment=comment;
        this.reviewerId=reviewerId;
        this.teacherId=teacherId;
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

    public Long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public UserEntity getRepetitor() {
        return repetitor;
    }

    public void setRepetitor(UserEntity repetitor) {
        this.repetitor = repetitor;
    }

    @ManyToOne
    private UserEntity repetitor;


}
