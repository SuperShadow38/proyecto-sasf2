package com.api.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.repository.UserSecurityRepository;

import com.api.model.Loggers;
import com.api.model.LoggersRoles;

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

        System.out.println(loggers);

            
        String[] roles = loggers.getRoles().stream().map(LoggersRoles::getRol).toArray(String[]::new);

           
        return User.builder()
                .username(loggers.getUsuario())
                .password(loggers.getContraseña_usuarios())
                .authorities(this.grantedAuthorities(roles))
                .build();
    }

    private String[] getAuthorities(String role) {
        if ("ADMIN".equals(role) || "NORMAL".equals(role)){
            return new String[] {"random_order"};
        }

        return new String[] {};
    }  

    private List<GrantedAuthority> grantedAuthorities(String[] roles) {
        List<GrantedAuthority> authorities = new ArrayList<>(roles.length);

        for(String role: roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        
            for (String authority: this.getAuthorities(role)) {
                authorities.add(new SimpleGrantedAuthority(authority));
            }
        }
        return authorities;
    }
}
