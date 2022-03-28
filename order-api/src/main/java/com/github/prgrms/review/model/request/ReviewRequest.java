package com.github.prgrms.review.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class ReviewRequest {

    @NotNull
    @Size(max = 1000)
    String content;

    public ReviewRequest(String content) {
        this.content = content;
    }
}
