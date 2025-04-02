package com.example.scheduler_jpa.user.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserUpdateRequestDto {
    private String email;
    private String password;
    private String username;

    public UserUpdateRequestDto(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
