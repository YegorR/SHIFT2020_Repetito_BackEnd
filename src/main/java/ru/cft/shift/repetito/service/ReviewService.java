package ru.cft.shift.repetito.service;

import ru.cft.shift.repetito.entity.ReviewEntity;
import ru.cft.shift.repetito.params.response.ReviewFullResponse;
import ru.cft.shift.repetito.params.response.ReviewSimpleResponse;

import java.util.List;

public interface ReviewService {
    List<ReviewSimpleResponse> get(Long repetitorId);
    ReviewFullResponse add(ReviewEntity review);
}
