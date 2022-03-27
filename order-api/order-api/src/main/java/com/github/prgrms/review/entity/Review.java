package com.github.prgrms.review.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.time.LocalDateTime.now;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;


@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "reviews")
@Entity
public class Review {
    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "review_id_seq")
    private Long seq;

    @Column(name = "user_seq", nullable = false)
    private Long userSeq;

    @Column(name = "product_seq", nullable = false)
    private Long productId;

    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Builder
    public Review(Long seq, Long userSeq, Long productId, String content, LocalDateTime createAt) {
      this.seq = seq;
      this.userSeq = userSeq;
      this.productId = productId;
      this.content = content;
      this.createAt = createAt;
    }
}