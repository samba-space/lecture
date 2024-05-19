package com.example.orderservice.dto;

import com.example.orderservice.entity.OrderEntity;

public record FindOrderResponse(
        String productId,
        Long quantity,
        Long unitPrice,
        Long totalPrice,
        String orderId
) {
    public static FindOrderResponse from(OrderEntity order) {
        return new FindOrderResponse(order.getProductId(), order.getQuantity(), order.getUnitPrice(), order.getTotalPrice(), order.getOrderId());
    }
}
