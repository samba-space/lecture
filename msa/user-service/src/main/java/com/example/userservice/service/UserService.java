package com.example.userservice.service;

import com.example.userservice.client.OrderServiceClient;
import com.example.userservice.dto.FindOrderResponse;
import com.example.userservice.dto.FindUserAndOrderResponse;
import com.example.userservice.dto.FindUserResponse;
import com.example.userservice.dto.UserCreateRequest;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final OrderServiceClient orderServiceClient;
    private final CircuitBreakerFactory circuitBreakerFactory;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, OrderServiceClient orderServiceClient, CircuitBreakerFactory circuitBreakerFactory) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.orderServiceClient = orderServiceClient;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    public void createUser(UserCreateRequest userCreateRequest) {
        userRepository.save(userCreateRequest.toEntityWithUserIdAndEncryptPassword(UUID.randomUUID().toString(), passwordEncoder.encode(userCreateRequest.password())));
    }

    public FindUserAndOrderResponse findUserById(String userId) {
        log.info("before call order msa");
        UserEntity findUser = userRepository.findByUserId(userId);
        CircuitBreaker circuitbreaker = circuitBreakerFactory.create("circuitbreaker");
        List<FindOrderResponse> findOrders = circuitbreaker.run(() -> orderServiceClient.getOrders(userId),
                throwable -> List.of());
        log.info("after call order msa");
        return FindUserAndOrderResponse.of(findUser, findOrders);
    }

    public List<FindUserResponse> findUsers() {
        return userRepository.findAll().stream()
                .map(FindUserResponse::of)
                .toList();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity findUser = userRepository.findByEmail(username);
        if (findUser == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(username, findUser.getEncryptedPassword(), new ArrayList<>());
    }

    public FindUserResponse getUserDetailsByEmail(String username) {
        return FindUserResponse.of(userRepository.findByEmail(username));
    }
}
