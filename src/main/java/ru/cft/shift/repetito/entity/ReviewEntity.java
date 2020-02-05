package ru.cft.shift.repetito.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="reviews")
public class ReviewEntity {
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @Column(name = "mark")
    private int mark;

    @Column(name = "comment")
    private String  comment;

    @Column(name = "reviewer_id")
    private Long reviewerId;

    @Column(name = "teacher_id")
    private  Long teacherId;

}
