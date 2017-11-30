package sk.bavaria.bavaria.service;

import sk.bavaria.bavaria.model.Review;

import java.util.List;


public interface ReviewService {
    List<Review> getAllReviews();
    List<Review> getAllApprovedReviews();
    void approveReview(long id);
    void saveReview(Review review);
    void deleteReviewByID(long id);

}
