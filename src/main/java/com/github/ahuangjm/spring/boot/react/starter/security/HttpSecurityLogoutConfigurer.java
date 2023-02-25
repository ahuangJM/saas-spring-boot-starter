package com.github.ahuangjm.spring.boot.react.starter.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.stereotype.Component;

@Component
public class HttpSecurityLogoutConfigurer {
    public void configure(LogoutConfigurer<HttpSecurity> logout) {
        logout.permitAll();
    }
}
