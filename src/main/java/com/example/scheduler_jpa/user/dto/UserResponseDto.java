package com.example.scheduler_jpa.user.dto;

import com.example.scheduler_jpa.user.entity.User;
import lombok.Getter;

//유저 정보 반환 dto
@Getter
public class UserResponseDto {
    private final String userName;
    private final String email;

    public UserResponseDto(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public static UserResponseDto todto(User user){
        return new UserResponseDto(user.getUserName(),user.getEmail());
    }
}
