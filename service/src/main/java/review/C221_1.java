package review;

import edu.sm.dto.Review;
import edu.sm.service.ReviewService;

public class C221_1 {
    public static void main(String[] args) {
        ReviewService reviewService = new ReviewService();
        Review review = Review.builder()
                .review_title("67522")
                .review_text("22222222")
                .review_star(4)
                .review_id(1)
                .build();
        try {
            reviewService.C221_1(review);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}