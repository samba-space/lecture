package com.example.catalogservice.controller;

import com.example.catalogservice.dto.FindCatalogResponse;
import com.example.catalogservice.service.CatalogService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CatalogController {

    private final Environment environment;
    private final CatalogService catalogService;

    public CatalogController(Environment environment, CatalogService catalogService) {
        this.environment = environment;
        this.catalogService = catalogService;
    }

    @GetMapping("/health_check")
    public String status() {
        return "health check";
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<FindCatalogResponse>> findCatalogs() {
        return ResponseEntity.status(HttpStatus.OK).body(catalogService.findCatalogs());
    }
}
