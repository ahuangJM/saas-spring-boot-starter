package com.github.ahuangjm.spring.boot.react.starter.configs;

import com.github.ahuangjm.spring.boot.react.starter.security.HttpSecurityAuthorizeHttpRequestsConfigurer;
import com.github.ahuangjm.spring.boot.react.starter.security.HttpSecurityFormLoginConfigurer;
import com.github.ahuangjm.spring.boot.react.starter.security.HttpSecurityLogoutConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    private final HttpSecurityAuthorizeHttpRequestsConfigurer httpSecurityAuthorizeHttpRequestsConfigurer;
    private final HttpSecurityFormLoginConfigurer httpSecurityFormLoginConfigurer;
    private final HttpSecurityLogoutConfigurer httpSecurityLogoutConfigurer;

    public WebSecurityConfig(
            final HttpSecurityAuthorizeHttpRequestsConfigurer httpSecurityAuthorizeHttpRequestsConfigurer,
            final HttpSecurityFormLoginConfigurer httpSecurityFormLoginConfigurer,
            final HttpSecurityLogoutConfigurer httpSecurityLogoutConfigurer) {
        this.httpSecurityAuthorizeHttpRequestsConfigurer = httpSecurityAuthorizeHttpRequestsConfigurer;
        this.httpSecurityFormLoginConfigurer = httpSecurityFormLoginConfigurer;
        this.httpSecurityLogoutConfigurer = httpSecurityLogoutConfigurer;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(final HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(this.httpSecurityAuthorizeHttpRequestsConfigurer::configure)
                .formLogin(this.httpSecurityFormLoginConfigurer::configure)
                .logout(this.httpSecurityLogoutConfigurer::configure)
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        final UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }






}
