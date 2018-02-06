package sk.bavaria.bavaria.service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.bavaria.bavaria.model.Review;
import sk.bavaria.bavaria.serviceImpl.ReviewServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/review")
@Api(value="/gallery", description="Basic crud over review entity.")
public class ReviewService {

    @Autowired
    ReviewServiceImpl reviewService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void saveReview(@RequestBody Review review) throws Exception {
        Review review1 = new Review();
        review1.setNickName(review.getNickName());
        review1.setRating(review.getRating());
        review1.setDate(review.getDate());
        review1.setMessage(review.getMessage());
        reviewService.saveReview(review1);
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/approved")
    public List<Review> getAllApprovedReviews() {
        return reviewService.getAllApprovedReviews();
    }

    @PostMapping("/delete/{id}")
    public void deleteReviewById(@PathVariable(value="id") int id) {
        reviewService.deleteReviewByID(id);
    }

    @PostMapping("/approve/{id}")
    public void approveReviewById(@PathVariable(value="id") int id) {

        reviewService.approveReview(id);
    }









}
