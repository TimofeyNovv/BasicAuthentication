package org.example.basiauth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.basiauth.dto.ErrorResponse;
import org.example.basiauth.dto.RegisterRequest;
import org.example.basiauth.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;


    @Operation(
            summary = "эндпоинт для регистрации пользователя",
            responses = {
                    @ApiResponse(responseCode = "204", description = "пользователь успешно зарегистрирован"),
                    @ApiResponse(responseCode = "409", description = "пользователь с таким email уже существует", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "400", description = "невалидный json или некорректное заполнение полей json", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    @PostMapping("/register")
    public ResponseEntity<?> register(
            @Valid @RequestBody RegisterRequest request
    ) {
        authenticationService.register(request);
        return ResponseEntity.noContent().build();
    }
}
