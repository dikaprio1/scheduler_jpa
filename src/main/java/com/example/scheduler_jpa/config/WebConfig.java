package com.example.scheduler_jpa.config;

import com.example.scheduler_jpa.filter.LoginFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    // 필터 빈 등록
    @Bean
    public FilterRegistrationBean loginFilter() {
    FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
    filterRegistrationBean.setFilter(new LoginFilter()); // Filter 등록
    filterRegistrationBean.setOrder(1); // Filter 순서 2 설정
    filterRegistrationBean.addUrlPatterns("/*"); // 전체 URL에 Filter 적용

    return filterRegistrationBean;
    }
}
