package com.github.prgrms.orders.model.response;

import com.github.prgrms.orders.entity.Order;
import com.github.prgrms.orders.model.dto.OrderDto;
import com.github.prgrms.orders.model.enums.OrderStatus;
import com.github.prgrms.review.model.dto.ReviewDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderResponse {

    private Long seq;
    private Long userSeq;
    private Long productId;
    private ReviewDto review;
    private String requestMessage;
    private String rejectMessage;
    private OrderStatus state;
    private LocalDateTime completedAt;
    private LocalDateTime rejectedAt;
    private LocalDateTime createAt;

    public static OrderResponse of(Order source) {
        ReviewDto review = null;

        if( source.getReview() != null ){
            review = ReviewDto.builder()
                    .seq(source.getReview().getSeq())
                    .productId(source.getReview().getProductId())
                    .content(source.getReview().getContent())
                    .createAt(source.getReview().getCreateAt())
                    .build();
        }

        return OrderResponse.builder()
                .seq(source.getSeq())
                .userSeq(source.getUserSeq())
                .productId(source.getProductId())
                .review(review)
                .rejectMessage(source.getRejectMessage())
                .requestMessage(source.getRequestMessage())
                .state(source.getState())
                .completedAt(source.getCompletedAt())
                .rejectedAt(source.getRejectedAt())
                .createAt(source.getCreateAt())
                .build();
    }

    @Builder
    public OrderResponse(Long seq, Long userSeq, Long productId, ReviewDto review, String requestMessage, String rejectMessage, OrderStatus state, LocalDateTime completedAt, LocalDateTime rejectedAt, LocalDateTime createAt) {

        this.seq = seq;
        this.userSeq = userSeq;
        this.productId = productId;
        this.review = review;
        this.requestMessage = requestMessage;
        this.rejectMessage = rejectMessage;
        this.state = state;
        this.completedAt = completedAt;
        this.rejectedAt = rejectedAt;
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("seq", seq)
                .append("productId", productId)
                .append("review", review)
                .append("requestMessage", requestMessage)
                .append("rejectMessage", rejectMessage)
                .append("state", state)
                .append("completedAt", completedAt)
                .append("completedAt", rejectedAt)
                .append("completedAt", createAt)
                .toString();
    }
}

