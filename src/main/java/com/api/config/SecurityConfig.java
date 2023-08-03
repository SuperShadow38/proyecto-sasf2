package com.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain FilterChain (HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .cors().and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET, "/api/users/**").hasAnyRole("ADMIN", "NORMAL")
                .antMatchers(HttpMethod.POST, "/api/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/users/*").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
