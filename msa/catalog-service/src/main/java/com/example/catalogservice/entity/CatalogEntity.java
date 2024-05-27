package com.example.catalogservice.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Entity
@Table(name = "catalog")
public class CatalogEntity implements Serializable {

    protected CatalogEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Long stock;

    @Column(nullable = false)
    private Long unitPrice;
    public void decreaseStock(Integer quantity) {
        stock = stock - quantity;
    }
}
