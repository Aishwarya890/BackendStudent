package com.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/subjects/**","/api/students/**").permitAll() // Allows public access to resume endpoints
                .anyRequest().authenticated()
            );
        return http.build();
    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf().disable()  // Disable CSRF for testing, not recommended for production
//            .authorizeRequests()
//            .requestMatchers("/api/students/**","/api/subject/**").permitAll()  // Allow access to student API
//            .anyRequest().authenticated()
//            .and()
//            .httpBasic();  // Or formLogin() if using form-based login
//
//        return http.build();
//    }
}