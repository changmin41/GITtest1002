package review;

import edu.sm.dto.Review;
import edu.sm.service.ReviewService;

public class C211_2 {
    public static void main(String[] args) {
        ReviewService reviewService = new ReviewService();
        Review review = Review.builder()
                .review_id(1)
                .build();
        try {
            reviewService.C221_2(review);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
