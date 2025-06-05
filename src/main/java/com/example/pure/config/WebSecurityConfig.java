package com.example.pure.config;

import com.example.pure.service.CustomOAuth2UserService;
import org.apache.catalina.security.SecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Class WebSecurityConfig конфигурация безопасности
 */
public class WebSecurityConfig {

    private final CustomOAuth2UserService service;

    public WebSecurityConfig(CustomOAuth2UserService service) {
        this.service = service;
    }

    @Bean
    public SecurityFilterChain filter (HttpSecurity http)throws Exception {
        http
                .authorizeHttpRequests(it -> it.requestMatchers("/login**", "/error")
                        .permitAll().anyRequest().authenticated())
                .oauth2Login(it -> it.userInfoEndpoint(itUser -> itUser.userService(service)))
                .logout(it -> it.logoutSuccessUrl("/").permitAll());
        return http.build();
    }
}
