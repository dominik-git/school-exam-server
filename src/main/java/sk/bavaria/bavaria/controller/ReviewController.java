package sk.bavaria.bavaria.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.bavaria.bavaria.model.Review;
import sk.bavaria.bavaria.service.ReviewService;
import java.util.List;

@RestController
@RequestMapping("/review")
@Api(value="/gallery", description="Basic crud over review entity.")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void saveReview(@RequestBody Review review) throws Exception {
        reviewService.saveReview(review);
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
