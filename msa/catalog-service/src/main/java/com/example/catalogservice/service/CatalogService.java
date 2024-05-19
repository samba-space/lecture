package com.example.catalogservice.service;

import com.example.catalogservice.dto.FindCatalogResponse;
import com.example.catalogservice.repository.CatalogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {
    private final CatalogRepository catalogRepository;

    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public List<FindCatalogResponse> findCatalogs() {
        return catalogRepository.findAll().stream()
                .map(FindCatalogResponse::of)
                .toList();
    }
}
