package com.github.prgrms.review.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewRequest {

    String content;

    public ReviewRequest(String content) {
        this.content = content;
    }
}
