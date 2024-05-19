package com.example.userservice.dto;


import com.example.userservice.entity.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserCreateRequest(

        @NotNull
        @Size(min = 2)
        @Email
        String email,

        @NotNull
        @Size(min = 2)
        String name,
        @NotNull
        @Size(min = 8)
        String password
) {
        public UserEntity toEntityWithUserIdAndEncryptPassword(String userId, String encryptPassword) {
                return new UserEntity(email, name, userId, encryptPassword);
        }
}
