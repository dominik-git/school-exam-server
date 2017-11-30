package sk.bavaria.bavaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.bavaria.bavaria.model.Review;
import sk.bavaria.bavaria.repository.ReviewRepository;

import java.util.List;
import java.util.Objects;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> getAllApprovedReviews() {
        return reviewRepository.findByApproved(true);
    }

    @Override
    public void approveReview(long id) {
        Review review = reviewRepository.findOne(id);
        Objects.nonNull(review);
        review.setApproved(true);
        reviewRepository.save(review);
    }

    @Override
    public void saveReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void deleteReviewByID(long id) {
        reviewRepository.delete(id);
    }
}
