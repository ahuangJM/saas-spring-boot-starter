package com.github.ahuangjm.spring.boot.react.starter.managers;

import javax.servlet.http.Cookie;

public interface CookieConstructor {
    Cookie construct(final String value);
}
