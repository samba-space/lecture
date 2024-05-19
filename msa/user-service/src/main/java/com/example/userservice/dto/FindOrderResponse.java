package com.example.userservice.dto;

public record FindOrderResponse (
     String productId,
     Long quantity,
    Long unitPrice,
     Long totalPrice
){}
