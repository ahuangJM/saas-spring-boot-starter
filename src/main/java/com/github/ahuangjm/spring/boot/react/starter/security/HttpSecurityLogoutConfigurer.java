package com.github.ahuangjm.spring.boot.react.starter.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.stereotype.Component;

@Component
public class HttpSecurityLogoutConfigurer {
    private final LogoutSuccessHandler logoutSuccessHandler;

    public HttpSecurityLogoutConfigurer(final LogoutSuccessHandler logoutSuccessHandler) {
        this.logoutSuccessHandler = logoutSuccessHandler;
    }

    public void configure(final LogoutConfigurer<HttpSecurity> logout) {
        logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(this.logoutSuccessHandler)
                .permitAll();
    }
}
