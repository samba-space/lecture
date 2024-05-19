package com.example.userservice.service;

import com.example.userservice.dto.FindOrderResponse;
import com.example.userservice.dto.FindUserAndOrderResponse;
import com.example.userservice.dto.FindUserResponse;
import com.example.userservice.dto.UserCreateRequest;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(UserCreateRequest userCreateRequest) {
        userRepository.save(userCreateRequest.toEntityWithUserIdAndEncryptPassword(UUID.randomUUID().toString(), passwordEncoder.encode(userCreateRequest.password())));
    }

    public FindUserAndOrderResponse findUserById(String userId) {
        UserEntity findUser = userRepository.findByUserId(userId);
        List<FindOrderResponse> orders = new ArrayList<>();
        return FindUserAndOrderResponse.of(findUser, orders);
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
