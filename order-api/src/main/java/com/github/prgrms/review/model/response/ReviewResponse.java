package com.github.prgrms.review.model.response;

import com.github.prgrms.review.entity.Review;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;



@Getter
public class ReviewResponse {
    private final Long seq;
    private final Long productId;
    private final String content;
    private final LocalDateTime createAt;

    @Builder
    public ReviewResponse(Long seq, Long productId, String content, LocalDateTime createAt) {
        this.seq = seq;
        this.productId = productId;
        this.content = content;
        this.createAt = createAt;
    }

    public static ReviewResponse of(Review review){
        return ReviewResponse.builder()
                .seq(review.getSeq())
                .productId(review.getProductId())
                .content(review.getContent())
                .createAt(review.getCreateAt())
                .build();

    }
}