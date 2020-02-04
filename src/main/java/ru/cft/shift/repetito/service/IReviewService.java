package ru.cft.shift.repetito.service;

import ru.cft.shift.repetito.entity.ReviewEntity;

public interface IReviewService {
    ReviewEntity get(Long teacher_id);
    ReviewEntity add(Long teacher_id, int mark, String comment, );
}
