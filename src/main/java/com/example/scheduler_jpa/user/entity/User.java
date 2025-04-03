package com.example.scheduler_jpa.user.entity;

import com.example.scheduler_jpa.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "이름은 필수 입력값입니다.")
    private String userName;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",message="올바른 이메일 형식이 아닙니다.")
    @Column(nullable = false, unique = true)
    @NotBlank(message = "이메일은 필수 입력값입니다.")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "비밀번호은 필수 입력값입니다.")
    private String password;

    public User() {
    }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
