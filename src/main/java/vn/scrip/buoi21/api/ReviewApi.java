package vn.scrip.buoi21.api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.scrip.buoi21.entity.Review;
@RestController
@RequestMapping("api/reviews")

public class ReviewApi
{
    private final ReviewService reviewService;
    @GetMapping()
    public ResponseEntity<?> getReviews(@RequestParam(defaultValue = "1")Integer page,
                                        @RequestParam(defaultValue = "5")Integer pageSize,
                                        @RequestParam Integer movieId) {
        Page<Review>reviewPage = reviewService.getReviewsByMovie(movieId,page,pageSize);
        return ResponseEntity.ok(reviewPage);
    }
    @PostMapping()

    public ResponseEntity<?>createReview()
    {
        return null;
    }
    @PutMapping()
    public ResponseEntity<?>updateReview(){
        return null;
    }
    @DeleteMapping()
    public ResponseEntity<?>deleteReview(){
        return null;
    }
}

















