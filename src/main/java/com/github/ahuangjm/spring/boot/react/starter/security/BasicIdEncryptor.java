package com.github.ahuangjm.spring.boot.react.starter.security;

import org.springframework.stereotype.Component;

@Component
public class BasicIdEncryptor implements IdEncryptor {
    public String getKey(final long id) {
        return String.valueOf(id);
    }
}
