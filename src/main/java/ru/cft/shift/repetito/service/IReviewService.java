package ru.cft.shift.repetito.service;

import ru.cft.shift.repetito.entity.ReviewEntity;

import java.util.List;

public interface IReviewService {
    List<ReviewEntity> get(Long teacher_id);
    ReviewEntity add(ReviewEntity review);
}
