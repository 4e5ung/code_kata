package com.github.prgrms.orders.api;

import com.github.prgrms.orders.model.request.OrderRejectRequest;
import com.github.prgrms.orders.model.response.OrderResponse;
import com.github.prgrms.orders.service.OrderService;
import com.github.prgrms.security.token.JwtAuthentication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nullable;
import java.util.List;

import static com.github.prgrms.utils.ApiUtils.ApiResult;
import static com.github.prgrms.utils.ApiUtils.success;
import static com.github.prgrms.utils.ApiUtils.error;


@RestController
@RequestMapping("api/orders")
public class OrderRestController {
    private final OrderService orderService;
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ApiResult<List<OrderResponse>> findAll(
            @AuthenticationPrincipal JwtAuthentication authentication,
            Pageable pageable) {
        return success(orderService.findByUserSeqOrderBySeqDesc(authentication.id, pageable));
    }

    @GetMapping(path = "{id}")
    public ApiResult<OrderResponse> findById(
            @AuthenticationPrincipal JwtAuthentication authentication,
            @PathVariable(name = "id") Long orderId){

        return success(orderService.findBySeqAndUserSeq(authentication.id, orderId));
    }

    @PatchMapping(path = "{id}/accept")
    public ApiResult<Boolean> accept(@AuthenticationPrincipal JwtAuthentication authentication,
                                     @PathVariable(name = "id") Long orderId){
        return success(orderService.updateAccepted(authentication.id, orderId));
    }

    @PatchMapping(path = "{id}/shipping")
    public ApiResult<Boolean> shipping(@AuthenticationPrincipal JwtAuthentication authentication,
                                       @PathVariable(name = "id") Long orderId){
        return success(orderService.updateShipping(authentication.id, orderId));
    }

    @PatchMapping(path = "{id}/complete")
    public ApiResult<Boolean> complete(@AuthenticationPrincipal JwtAuthentication authentication,
                                       @PathVariable(name = "id") Long orderId){

        return success(orderService.updateComplete(authentication.id, orderId));
    }


    @PatchMapping(path = "{id}/reject")
    public ApiResult reject(
            @AuthenticationPrincipal JwtAuthentication authentication,
            @PathVariable(name = "id") Long orderId,
            @RequestBody @Nullable OrderRejectRequest orderRejectRequest
    ) throws MethodArgumentNotValidException {

//        if( orderRejectRequest == null )
//            throw new MethodArgumentNotValidException(null, null);

        return success(orderService.updateReject(authentication.id, orderId, orderRejectRequest.getMessage()));
    }
}