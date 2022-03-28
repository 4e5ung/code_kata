package com.github.prgrms.review.api;

import com.github.prgrms.orders.model.request.OrderRejectRequest;
import com.github.prgrms.review.model.dto.ReviewDto;
import com.github.prgrms.review.model.request.ReviewRequest;
import com.github.prgrms.review.model.response.ReviewResponse;
import com.github.prgrms.review.service.ReviewService;
import com.github.prgrms.security.token.JwtAuthentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nullable;
import javax.validation.Valid;
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
    public ApiResult<ReviewResponse> review(@AuthenticationPrincipal JwtAuthentication authentication,
                                            @PathVariable(name="id") Long orderId,
                                            @Valid @RequestBody ReviewRequest reviewRequest){

        return success(reviewService.updateReview(
                authentication.id,
                orderId,
                reviewRequest.getContent())
        );
    }
}