package com.example.scheduler_jpa.Auth.dto;

import lombok.Getter;

@Getter
// 로그인 요청 dto
public class LoginRequest {
    private final String email;
    private final String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
