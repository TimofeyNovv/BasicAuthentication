package org.example.basiauth.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.example.basiauth.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
@RequiredArgsConstructor
public class DemoController {

    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return ResponseEntity.ok().body("pong");
    }

    @SecurityRequirement(name = "basicAuth")
    @GetMapping("/authping")
    public ResponseEntity<String> authping(@AuthenticationPrincipal UserEntity userEntity){
        System.out.println(userEntity);
        return ResponseEntity.ok().body("auth ping");
    }
}
