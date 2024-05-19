package com.example.orderservice.dto;

import com.example.orderservice.entity.OrderEntity;

import java.util.UUID;

public record CreateOrderRequest(
        String productId,
        Long quantity,
        Long unitPrice
) {
    public OrderEntity toEntity(String userId) {
        return new OrderEntity(productId, quantity, unitPrice,
                quantity * unitPrice, userId, UUID.randomUUID().toString());
    }
}
