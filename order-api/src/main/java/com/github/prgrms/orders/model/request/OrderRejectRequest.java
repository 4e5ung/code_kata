package com.github.prgrms.orders.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class OrderRejectRequest {

    @NotNull
    String message;

    public OrderRejectRequest(String message) {
        this.message = message;
    }
}
