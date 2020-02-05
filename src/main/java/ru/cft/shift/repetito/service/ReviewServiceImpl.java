package ru.cft.shift.repetito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shift.repetito.entity.ReviewEntity;
import ru.cft.shift.repetito.repository.ReviewRepository;

import java.util.List;

@Service
public class ReviewServiceImpl implements  ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<ReviewEntity> get(Long repetitorId){
        return reviewRepository.findByRepetitorId(repetitorId);
    }

    @Override
    public ReviewEntity add(ReviewEntity review)
    {
        return reviewRepository.save(review);
    }
}
