package com.github.ahuangjm.spring.boot.react.starter.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.stereotype.Component;

@Component
public class HttpSecurityFormLoginConfigurer {
    private final LoginSuccessHandler loginSuccessHandler;

    public HttpSecurityFormLoginConfigurer(final LoginSuccessHandler loginSuccessHandler) {
        this.loginSuccessHandler = loginSuccessHandler;
    }

    public void configure(final FormLoginConfigurer<HttpSecurity> form) {
        form
                .loginProcessingUrl("/login")
                .loginPage("/login")
                .successHandler(this.loginSuccessHandler)
                .permitAll();
    }
}
