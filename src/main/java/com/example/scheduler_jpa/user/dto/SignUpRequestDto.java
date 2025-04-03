package com.example.scheduler_jpa.user.dto;

import lombok.Getter;

//유저 등록 요청 dto
@Getter
public class SignUpRequestDto {
    private final String userName;
    private final String email;
    private final String password;

    public SignUpRequestDto(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
