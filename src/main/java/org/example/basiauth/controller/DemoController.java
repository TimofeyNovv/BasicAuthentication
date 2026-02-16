package org.example.basiauth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
@RequiredArgsConstructor
public class DemoController {

    @Operation(
            summary = "базовый ping"
    )
    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok().body("pong");
    }

    @Operation(
            summary = "ping доступный только авторизованным пользователям"
    )
    @SecurityRequirement(name = "basicAuth")
    @GetMapping("/authping")
    public ResponseEntity<String> authping() {
        return ResponseEntity.ok().body(" auth ping");
    }
}
