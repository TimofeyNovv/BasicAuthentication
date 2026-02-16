package org.example.basiauth.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.basiauth.dto.RegisterRequest;
import org.example.basiauth.entity.UserEntity;
import org.example.basiauth.entity.UserRole;
import org.example.basiauth.exception.UserAlreadyExistsException;
import org.example.basiauth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())){
            throw new UserAlreadyExistsException("user with email - " + request.getEmail() + " already exists");
        }
        UserEntity userEntity = UserEntity.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(UserRole.USER)
                .build();

        userRepository.save(userEntity);
    }
}
