package com.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.repository.UserSecurityRepository;

import com.api.model.Loggers;

@Service
public class UserSecurityService implements UserDetailsService {
    private final UserSecurityRepository userSecurityRepository;
    
    @Autowired
    public UserSecurityService(UserSecurityRepository userSecurityRepository) {
        this.userSecurityRepository = userSecurityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Loggers loggers = this.userSecurityRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User" + username + "not found."));
        return User.builder()
                .username(loggers.getUsuario())
                .password(loggers.getContraseña_usuarios())
                .roles("ADMIN")
                .build();
    }
}
