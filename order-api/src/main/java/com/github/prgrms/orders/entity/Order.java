package com.github.prgrms.orders.entity;

import com.github.prgrms.orders.model.enums.OrderStatus;
import com.github.prgrms.products.entity.Product;
import com.github.prgrms.review.entity.Review;
import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.From;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Orders")
@Entity
public class Order {
    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long seq;

    @Column(name = "user_seq", nullable = false)
    private Long userSeq;

    @Column(name = "product_seq", nullable = false)
    private Long productId;

    @Column(name = "review_seq", unique = true)
    private Long reviewSeq;

    @Column(name = "request_msg", nullable = false, length = 1000)
    private String requestMessage;

    @Column(name = "reject_msg", nullable = false, length = 1000)
    private String rejectMessage;

    @Column(name = "state")
    @Enumerated(value = EnumType.STRING)
    private OrderStatus state;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(name = "rejected_at")
    private LocalDateTime rejectedAt;

    @Column(name = "create_at", nullable = false)
    private LocalDateTime createAt;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="review_seq", insertable = false, updatable = false)
    private Review review;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_seq", insertable = false, updatable = false)
    private Product product;

    @Builder
    public Order(Long seq, Long userSeq, Long productId, Long reviewSeq, String requestMessage, String rejectMessage, OrderStatus state, LocalDateTime completedAt, LocalDateTime rejectedAt, LocalDateTime createAt, Review review, Product product) {
        this.seq = seq;
        this.userSeq = userSeq;
        this.productId = productId;
        this.reviewSeq = reviewSeq;
        this.requestMessage = requestMessage;
        this.rejectMessage = rejectMessage;
        this.state = state;
        this.completedAt = completedAt;
        this.rejectedAt = rejectedAt;
        this.createAt = createAt;
        this.review = review;
        this.product = product;
    }
}
