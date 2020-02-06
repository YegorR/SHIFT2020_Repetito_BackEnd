package ru.cft.shift.repetito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shift.repetito.entity.ReviewEntity;
import ru.cft.shift.repetito.params.response.ReviewFullResponse;
import ru.cft.shift.repetito.params.response.ReviewSimpleResponse;
import ru.cft.shift.repetito.repository.ReviewRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements  ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<ReviewSimpleResponse> get(Long repetitorId){
        List<ReviewSimpleResponse> reviewsSimple = new ArrayList<>();
        List<ReviewEntity> reviews = reviewRepository.findByRepetitorId(repetitorId);
        for (ReviewEntity r : reviews)
            reviewsSimple.add(new ReviewSimpleResponse(r));
        return reviewsSimple;
    }

    @Override
    public ReviewFullResponse add(ReviewEntity review)
    {
        reviewRepository.save(review);
        return new ReviewFullResponse(review);
    }
}
