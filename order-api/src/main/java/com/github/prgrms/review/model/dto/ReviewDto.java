package com.github.prgrms.review.model.dto;

import com.github.prgrms.products.entity.Product;
import com.github.prgrms.review.entity.Review;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;

import static org.springframework.beans.BeanUtils.copyProperties;

@Getter
public class ReviewDto {

    private Long seq;
    private Long productId;
    private String content;
    private LocalDateTime createAt;

    public ReviewDto(Review source) {
        copyProperties(source, this);
    }

    @Builder
    public ReviewDto(Long seq, Long productId, String content, LocalDateTime createAt) {
        this.seq = seq;
        this.productId = productId;
        this.content = content;
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("seq", seq)
                .append("productId", productId)
                .append("content", content)
                .append("createAt", createAt)
                .toString();
    }
}
