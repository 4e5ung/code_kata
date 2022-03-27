package com.github.prgrms.orders.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Nullable;

@Getter
@NoArgsConstructor
public class OrderRejectRequest {
    String message;

    public OrderRejectRequest(String message) {
        this.message = message;
    }
}
