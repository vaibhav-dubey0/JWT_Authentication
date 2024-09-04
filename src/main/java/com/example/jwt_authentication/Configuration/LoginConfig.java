package com.example.jwt_authentication.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.core.userdetails.User;

@Configuration
public class LoginConfig {


@Bean
public UserDetailsService userDetailsService(){

    UserDetails adminUser = User
                .withUsername("Vaibhav")
                .password(passwordEncoder().encode("Vaibhav"))
                .roles("ADMIN")
                .build();

        UserDetails empUser = User
                .withUsername("Nikhil")
                .password(passwordEncoder().encode("Nikhil"))
                .roles("EMP")
                .build();

        return new InMemoryUserDetailsManager(adminUser, empUser);                 
}

@Bean
public PasswordEncoder passwordEncoder(){

    return new BCryptPasswordEncoder();
    
}
    
}
