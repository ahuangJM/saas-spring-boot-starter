package com.github.ahuangjm.spring.boot.react.starter.security;

import com.github.ahuangjm.spring.boot.react.starter.managers.CookieManager;
import com.github.ahuangjm.spring.boot.react.starter.managers.SaasAccountKeyManager;
import com.github.ahuangjm.spring.boot.react.starter.managers.SaasOrganizationKeyManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
    private final Set<CookieManager> cookieManagers = new HashSet<>();

    public LogoutSuccessHandler(
            final SaasAccountKeyManager saasAccountKeyManager,
            final SaasOrganizationKeyManager saasOrganizationKeyManager) {
        this.cookieManagers.add(saasAccountKeyManager);
        this.cookieManagers.add(saasOrganizationKeyManager);
    }

    @Override
    public void onLogoutSuccess(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final Authentication authentication) throws IOException, ServletException {
        this.cookieManagers.forEach(cookieManager -> cookieManager.destruct(request, response));
        super.onLogoutSuccess(request, response, authentication);
    }
}
