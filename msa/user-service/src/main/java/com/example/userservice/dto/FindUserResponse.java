package com.example.userservice.dto;

import com.example.userservice.entity.UserEntity;

public record FindUserResponse(
        String email,
        String name,
        String userId
) {
    public static FindUserResponse of(UserEntity user) {
        return new FindUserResponse(user.getEmail(), user.getName(), user.getUserId());
    }
}
