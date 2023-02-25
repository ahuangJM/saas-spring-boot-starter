package com.github.ahuangjm.spring.boot.react.starter.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.stereotype.Component;

@Component
public class HttpSecurityFormLoginConfigurer {
    public void configure(final FormLoginConfigurer<HttpSecurity> form) {
        form
                .loginProcessingUrl("/login")
                .loginPage("/login")
                .permitAll();
    }
}
