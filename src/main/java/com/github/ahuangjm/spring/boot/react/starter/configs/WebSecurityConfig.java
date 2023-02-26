package com.github.ahuangjm.spring.boot.react.starter.configs;

import com.github.ahuangjm.spring.boot.react.starter.security.HttpSecurityAuthorizeHttpRequestsConfigurer;
import com.github.ahuangjm.spring.boot.react.starter.security.HttpSecurityFormLoginConfigurer;
import com.github.ahuangjm.spring.boot.react.starter.security.HttpSecurityLogoutConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    private final HttpSecurityAuthorizeHttpRequestsConfigurer httpSecurityAuthorizeHttpRequestsConfigurer;
    private final HttpSecurityFormLoginConfigurer httpSecurityFormLoginConfigurer;
    private final HttpSecurityLogoutConfigurer httpSecurityLogoutConfigurer;
    private final DaoAuthenticationProvider daoAuthenticationProvider;

    public WebSecurityConfig(
            final HttpSecurityAuthorizeHttpRequestsConfigurer httpSecurityAuthorizeHttpRequestsConfigurer,
            final HttpSecurityFormLoginConfigurer httpSecurityFormLoginConfigurer,
            final HttpSecurityLogoutConfigurer httpSecurityLogoutConfigurer,
            final DaoAuthenticationProvider daoAuthenticationProvider) {
        this.httpSecurityAuthorizeHttpRequestsConfigurer = httpSecurityAuthorizeHttpRequestsConfigurer;
        this.httpSecurityFormLoginConfigurer = httpSecurityFormLoginConfigurer;
        this.httpSecurityLogoutConfigurer = httpSecurityLogoutConfigurer;
        this.daoAuthenticationProvider = daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(final HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authenticationProvider(this.daoAuthenticationProvider)
                .authorizeHttpRequests(this.httpSecurityAuthorizeHttpRequestsConfigurer::configure)
                .formLogin(this.httpSecurityFormLoginConfigurer::configure)
                .logout(this.httpSecurityLogoutConfigurer::configure)
                .build();
    }
}
