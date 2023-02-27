package com.github.ahuangjm.spring.boot.react.starter.security;

public interface IdEncryptor {
    String getKey(final long id) throws Exception;
}
