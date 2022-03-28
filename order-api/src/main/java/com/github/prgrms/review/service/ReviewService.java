package com.github.prgrms.review.service;

import com.github.prgrms.errors.NotFoundException;
import com.github.prgrms.orders.entity.Order;
import com.github.prgrms.orders.model.enums.OrderStatus;
import com.github.prgrms.orders.repository.OrderRepository;
import com.github.prgrms.products.entity.Product;
import com.github.prgrms.products.repository.ProductRepository;
import com.github.prgrms.review.entity.Review;
import com.github.prgrms.review.model.request.ReviewRequest;
import com.github.prgrms.review.model.response.ReviewResponse;
import com.github.prgrms.review.repository.ReviewRepository;
import com.github.prgrms.utils.ApiUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Objects;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.time.LocalDateTime.now;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public ReviewService(ReviewRepository reviewRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public Optional<Review> findById(Long reviewId) {
        checkNotNull(reviewId, "reviewId must be provided");

        return reviewRepository.findById(reviewId);
    }

    @Transactional()
    public ReviewResponse updateReview(Long userSeq, Long orderId, String content){
        Order order = orderRepository.findByUserSeqAndSeq(userSeq, orderId)
                .orElseThrow(
                        () -> new NotFoundException("not found")
                );

        if(order.getState() == OrderStatus.COMPLETED ){
            if (order.getReviewSeq() != null) {
                throw new IllegalStateException();
            }

            Review review = reviewRepository.save(Review.builder()
                    .content(content)
                    .productId(order.getProductId())
                    .userSeq(userSeq)
                    .build());

            order.setReviewSeq(review.getSeq());
            order.setReview(review);
            order.getProduct().addReviewCount();

            return ReviewResponse.of(review);
        }else {
            throw new IllegalStateException();
        }
    }
}
