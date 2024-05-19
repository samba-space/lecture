package com.example.catalogservice.dto;

import com.example.catalogservice.entity.CatalogEntity;

public record FindCatalogResponse(
        String productId,
        String productName,
        Long unitPrice,
        Long stock
) {
    public static FindCatalogResponse of(CatalogEntity catalog) {
        return new FindCatalogResponse(catalog.getProductId(), catalog.getProductName(),
                catalog.getUnitPrice(), catalog.getStock());
    }

}
