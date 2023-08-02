package com.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain FilterChain (HttpSecurity http) throws Exception{
        http.csrf().disable()
            .cors().and()
            .authorizeHttpRequests()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    
        return http.build();
    }
}
