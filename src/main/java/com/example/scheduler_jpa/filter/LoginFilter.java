package com.example.scheduler_jpa.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*") // 모든 요청을 필터링
public class LoginFilter implements Filter {
    private static final String[] WHITE_LIST = {"/", "/user/signup", "/login", "/logout"};
    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        String path = httpRequest.getRequestURI();

        if (path.startsWith("/users/signup") || path.startsWith("/auth/login")) {
            chain.doFilter(request, response);
            return;
        }
        // 로그인 상태 확인
        if (session == null || session.getAttribute("user") == null) {
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "로그인이 필요합니다.");
            System.out.println("로그인이 필요합니다.");
            return;
        }
        chain.doFilter(request, response);
    }
}

