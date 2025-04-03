package com.example.scheduler_jpa.user.dto;

import lombok.Getter;

//유저 등록 반환 dto
@Getter
public class SignResponseDto {
    private final String userName;
    private final String email;

    public SignResponseDto(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
