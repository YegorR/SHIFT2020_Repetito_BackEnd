package ru.cft.shift.repetito.service;

import ru.cft.shift.repetito.entity.ReviewEntity;

import java.util.List;

public interface ReviewService {
    List<ReviewEntity> get(Long repetitorId);
    ReviewEntity add(ReviewEntity review);
}
