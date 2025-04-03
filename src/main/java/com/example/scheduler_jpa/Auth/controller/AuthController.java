package com.example.scheduler_jpa.Auth.controller;

import com.example.scheduler_jpa.Auth.dto.LoginRequest;
import com.example.scheduler_jpa.Auth.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    // 회원 로그인 메서드
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        if (authService.login(loginRequest.getEmail(),loginRequest.getPassword(), request)) {
            log.info("로그인 성공");
            return ResponseEntity.ok("로그인 성공");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이메일 또는 비밀번호가 일치하지 않습니다.");
    }
}
