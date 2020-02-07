package ru.cft.shift.repetito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shift.repetito.entity.ReviewEntity;
import ru.cft.shift.repetito.params.response.ReviewFullResponse;
import ru.cft.shift.repetito.params.response.ReviewSimpleResponse;
import ru.cft.shift.repetito.repository.ReviewRepository;
import ru.cft.shift.repetito.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements  ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ReviewSimpleResponse> get(Long teacherId){
        List<ReviewSimpleResponse> reviewsSimple = new ArrayList<>();
        List<ReviewEntity> reviews = reviewRepository.findByTeacherId(teacherId);
        for (ReviewEntity r : reviews)
            reviewsSimple.add(new ReviewSimpleResponse(r));
        return reviewsSimple;
    }

    @Override
    public ReviewFullResponse add(ReviewEntity review)
    {
        int mark = review.getMark();
        int count = reviewRepository.countDistinctByTeacherId(review.getTeacher().getId());
        float avgMark = review.getTeacher().getAvgMark();
        float newAvgMark = (avgMark * count + mark) / (count + 1);
        review.getTeacher().setAvgMark(newAvgMark);
        userRepository.save(review.getTeacher());
        reviewRepository.save(review);
        return new ReviewFullResponse(review);
    }
}
