package com.github.ahuangjm.spring.boot.react.starter.configs;

import com.github.ahuangjm.spring.boot.react.starter.security.JpaUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserDetailsConfig {
    private final JpaUserDetailsService jpaUserDetailsService;

    public UserDetailsConfig(final JpaUserDetailsService jpaUserDetailsService) {
        this.jpaUserDetailsService = jpaUserDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.jpaUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
        return daoAuthenticationProvider;
    }
}
