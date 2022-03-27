package com.github.prgrms.review.api;

import com.github.prgrms.orders.model.request.OrderRejectRequest;
import com.github.prgrms.review.model.dto.ReviewDto;
import com.github.prgrms.review.model.request.ReviewRequest;
import com.github.prgrms.review.service.ReviewService;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nullable;
import java.util.List;

import static com.github.prgrms.utils.ApiUtils.success;
import static com.github.prgrms.utils.ApiUtils.ApiResult;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("api/orders")
public class ReviewRestController {

    final ReviewService reviewService;

    public ReviewRestController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping(path = "{id}/review")
    public ApiResult review(@PathVariable Long id, @RequestBody @Nullable ReviewRequest reviewRequest) throws MethodArgumentNotValidException {

        if( reviewRequest.getContent() == null )
            throw new MethodArgumentNotValidException(null, null);

        if( reviewRequest.getContent().length() > 1000 )
            throw new IllegalStateException(null, null);

        return success(reviewService.updateReview(id, reviewRequest.getContent()));
    }
}