package com.github.ahuangjm.spring.boot.react.starter.managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CookieDestructor {
    void destruct(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse);
}
