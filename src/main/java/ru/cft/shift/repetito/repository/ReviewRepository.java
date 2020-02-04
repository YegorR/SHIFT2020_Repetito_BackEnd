package ru.cft.shift.repetito.repository;

import ru.cft.shift.repetito.entity.ReviewEntity;

import java.util.List;

public interface ReviewRepository {
    ReviewEntity createReview(ReviewEntity review);

    List<ReviewEntity> findReviewByRepetitorId(long repetitorId);
}
