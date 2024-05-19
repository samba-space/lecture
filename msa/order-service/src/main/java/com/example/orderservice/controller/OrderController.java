package com.example.orderservice.controller;

import com.example.orderservice.dto.CreateOrderRequest;
import com.example.orderservice.dto.FindOrderResponse;
import com.example.orderservice.service.OrderService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-service")
public class OrderController {
    private final Environment environment;
    private final OrderService orderService;

    public OrderController(Environment environment, OrderService orderService) {
        this.environment = environment;
        this.orderService = orderService;
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity createOrder(@PathVariable String userId, @RequestBody CreateOrderRequest createOrderRequest) {
        orderService.createOrder(userId, createOrderRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<FindOrderResponse>> findOrderByUserId(@PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findOrdersByUserId(userId));
    }
}
