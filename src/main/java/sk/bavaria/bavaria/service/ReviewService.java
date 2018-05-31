package sk.bavaria.bavaria.service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.bavaria.bavaria.model.Review;
import sk.bavaria.bavaria.repository.ReviewRepository;

import java.util.List;

@RestController
@RequestMapping("/review")
@Api(value="/review", description="Basic crud over review entity.")
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void saveReview(@RequestBody Review review) throws Exception {
        reviewRepository.save(review);
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return  reviewRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteReviewById(@PathVariable(value="id") Long id) {
        reviewRepository.delete(id);
    }











}
