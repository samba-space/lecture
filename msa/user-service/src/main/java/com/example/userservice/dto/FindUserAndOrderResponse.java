package com.example.userservice.dto;

import com.example.userservice.entity.UserEntity;

import java.util.List;

public record FindUserAndOrderResponse(
        String email,
        String name,
        String userId,

        List<FindOrderResponse> orders
) {
    public static FindUserAndOrderResponse of(UserEntity user, List<FindOrderResponse> orders) {
        return new FindUserAndOrderResponse(user.getEmail(), user.getName(), user.getUserId(), orders);
    }
}
