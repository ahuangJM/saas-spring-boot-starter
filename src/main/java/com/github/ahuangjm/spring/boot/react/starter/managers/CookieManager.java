package com.github.ahuangjm.spring.boot.react.starter.managers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class CookieManager implements CookieConstructor, CookieDestructor, CookieDetails {
    @Override
    public Cookie construct(final String value) {
        final Cookie cookie = new Cookie(this.getName(), value);
        cookie.setMaxAge(this.getMaxAge());
        cookie.setComment(this.getComment());
        cookie.setDomain(this.getDomain());
        cookie.setPath(this.getPath());
        cookie.setSecure(this.getSecure());
        cookie.setHttpOnly(this.isHttpOnly());
        return cookie;
    }

    @Override
    public void destruct(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) {
        final Cookie[] cookies = httpServletRequest.getCookies();
        for (final Cookie cookie : cookies) {
            if (cookie.getName().equals(this.getName())) {
                cookie.setMaxAge(0);
                httpServletResponse.addCookie(cookie);
            }
        }
    }
}
