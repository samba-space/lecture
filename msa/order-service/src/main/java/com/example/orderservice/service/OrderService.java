package com.example.orderservice.service;

import com.example.orderservice.dto.CreateOrderRequest;
import com.example.orderservice.dto.FindOrderResponse;
import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(String userId, CreateOrderRequest createOrderRequest) {
        orderRepository.save(createOrderRequest.toEntity(userId));
    }

    public FindOrderResponse findOrderByOrderId(String orderId) {
        OrderEntity findOrder = orderRepository.findByOrderId(orderId);
        return FindOrderResponse.from(findOrder);
    }

    public List<FindOrderResponse> findOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId).stream()
                .map(FindOrderResponse::from)
                .toList();
    }
}
