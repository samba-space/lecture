package com.example.catalogservice.dto;

public record CreateCatalogRequest(
        String productId,
        Long quantity,
        Long unitPrice,
        Long totalPrice,
        String orderId,
        String userId
) {

}
