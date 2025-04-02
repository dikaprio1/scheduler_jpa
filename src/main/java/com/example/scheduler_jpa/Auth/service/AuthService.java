package com.example.scheduler_jpa.Auth.service;

import com.example.scheduler_jpa.user.entity.User;
import com.example.scheduler_jpa.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public boolean login(String email, String password, HttpServletRequest request) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            //비밀번호를 단순 문자열 비교
            if (password.equals(user.getPassword())) {
                // 세션 생성 및 유저 정보 저장
                HttpSession session = request.getSession();
                session.setAttribute("user", user.getEmail());
                return true;
            }
        }
        return false;
    }
}
