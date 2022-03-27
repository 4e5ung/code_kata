package com.github.prgrms.review.service;

import com.github.prgrms.orders.entity.Order;
import com.github.prgrms.orders.repository.OrderRepository;
import com.github.prgrms.products.entity.Product;
import com.github.prgrms.products.repository.ProductRepository;
import com.github.prgrms.review.entity.Review;
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
    public boolean updateReview(Long reviewSeq, String content) throws MethodArgumentNotValidException {
//        Review review = reviewRepository.findById(reviewSeq).orElseThrow(
//                () -> new IllegalArgumentException()
//        );

//        Order order = orderRepository.findByUserSeqAndReviewSeq(reviewSeq).orElseThrow(
//                () -> new IllegalArgumentException()
//        );

        if( !order.getState().equals("COMPLETED") ){
            throw new MethodArgumentNotValidException(null, null);
        }

        if( order.getReview() != null ){
            throw new IllegalStateException(null, null);
        }

        order.getReview().setSeq(reviewSeq);
        order.getReview().setProductId(order.getProductId());
        order.getReview().setContent(content);
        order.getReview().setCreateAt(now());


        Product product = productRepository.findById(order.getProductId()).orElseThrow(
                () -> new IllegalArgumentException()
        );

        product.setReviewCount(product.getReviewCount()+1);

        return true;
    }
}
