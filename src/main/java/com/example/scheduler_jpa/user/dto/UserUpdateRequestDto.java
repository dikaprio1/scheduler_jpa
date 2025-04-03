package com.example.scheduler_jpa.user.dto;

import lombok.Getter;
import lombok.Setter;

//유저 정보 수정 요청 dto
@Setter
@Getter
public class UserUpdateRequestDto {
    private String email;
    private String password;
    private String userName;

    public UserUpdateRequestDto(String email, String password, String userName) {
        this.email = email;
        this.password = password;
        this.userName = userName;
    }
}
