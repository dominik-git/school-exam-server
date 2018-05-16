package sk.bavaria.bavaria.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.bavaria.bavaria.model.Review;
import sk.bavaria.bavaria.repository.ReviewRepository;

import java.util.List;
import java.util.Objects;

@Service
public class ReviewServiceImpl {

    @Autowired
    private ReviewRepository reviewRepository;


    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }


    public void saveReview(Review review) {
        reviewRepository.save(review);
    }

    public void deleteReviewByID(long id) {
        reviewRepository.delete(id);
    }
}
