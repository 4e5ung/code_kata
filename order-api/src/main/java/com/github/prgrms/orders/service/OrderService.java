package com.github.prgrms.orders.service;

import com.github.prgrms.errors.NotFoundException;
import com.github.prgrms.orders.entity.Order;
import com.github.prgrms.orders.model.enums.OrderStatus;
import com.github.prgrms.orders.model.response.OrderResponse;
import com.github.prgrms.orders.repository.OrderRepository;
import com.github.prgrms.products.entity.Product;
import com.github.prgrms.products.repository.ProductRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.time.LocalDateTime.now;
import static java.util.stream.Collectors.toList;
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> findByUserSeqOrderBySeqDesc(Long userSeq, Pageable pageable) {
        checkNotNull(userSeq, "userSeq must be provided");

        return orderRepository.findByUserSeqOrderBySeqDesc(userSeq, pageable)
                .stream()
                .map(OrderResponse::of)
                .collect(toList());
    }


    @Transactional(readOnly = true)
    public OrderResponse findBySeqAndUserSeq(Long userSeq, Long orderId) {
        checkNotNull(userSeq, "userSeq must be provided");
        checkNotNull(orderId, "orderId must be provided");

        return orderRepository.findByUserSeqAndSeq(userSeq, orderId)
                .map(OrderResponse::of)
                    .orElseThrow(() -> new NotFoundException("Could not found order for " + orderId));
    }


    @Transactional(readOnly = true)
    public Optional<Order> findById(Long userSeq, Long orderId) {
        checkNotNull(orderId, "orderId must be provided");

        return orderRepository.findByUserSeqAndId(userSeq, orderId);
    }

    @Transactional(readOnly = true)
    public Optional<Order> findByReviewSeq(Long userSeq, Long reviewSeq) {
        checkNotNull(reviewSeq, "reviewSeq must be provided");

        return orderRepository.findByUserSeqAndReviewSeq(userSeq, reviewSeq);
    }

    @Transactional()
    public boolean updateAccepted(Long userSeq, Long orderId){
        Order order = orderRepository.findByUserSeqAndId(userSeq, orderId).orElseThrow(
                () -> new NotFoundException("not found")
        );



        if(order.getState() == OrderStatus.COMPLETED ){
            order.setState(OrderStatus.ACCEPTED);
            return true;
        }

        return false;
    }

    @Transactional()
    public boolean updateShipping(Long orderId){
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new IllegalArgumentException()
        );

        if(Objects.equals(order.getState(), OrderStatus.ACCEPTED)){
            order.setState(OrderStatus.SHIPPING);
            return true;
        }

        return false;
    }

    @Transactional()
    public boolean updateComplete(Long orderId){
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new IllegalArgumentException()
        );

        if(Objects.equals(order.getState(), OrderStatus.SHIPPING)){
            order.setState(OrderStatus.COMPLETED);
            order.setCompletedAt(now());
            return true;
        }

        return false;
    }

    @Transactional()
    public boolean updateReject(Long orderId, String message){
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new IllegalArgumentException()
        );

        if(Objects.equals(order.getState(), OrderStatus.REQUESTED)){
            order.setState(OrderStatus.REJECTED);
            order.setRejectedAt(now());
            order.setRejectMessage(message);
            return true;
        }

        return false;
    }
}
