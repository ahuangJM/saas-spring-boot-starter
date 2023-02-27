package com.github.ahuangjm.spring.boot.react.starter.security;

import com.github.ahuangjm.spring.boot.react.starter.entities.OrganizationEntity;
import com.github.ahuangjm.spring.boot.react.starter.managers.SaasAccountKeyManager;
import com.github.ahuangjm.spring.boot.react.starter.managers.SaasOrganizationKeyManager;
import com.github.ahuangjm.spring.boot.react.starter.models.Account;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final IdEncryptor idEncryptor;
    private final SaasAccountKeyManager saasAccountKeyManager;
    private final SaasOrganizationKeyManager saasOrganizationKeyManager;

    public LoginSuccessHandler(
            final BasicIdEncryptor basicIdEncryptor,
            final SaasAccountKeyManager saasAccountKeyManager,
            final SaasOrganizationKeyManager saasOrganizationKeyManager) {
        this.idEncryptor = basicIdEncryptor;
        this.saasAccountKeyManager = saasAccountKeyManager;
        this.saasOrganizationKeyManager = saasOrganizationKeyManager;
    }

    @Override
    public void onAuthenticationSuccess(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final Authentication authentication) throws IOException, ServletException {
        final Account account = (Account) authentication.getPrincipal();
        final OrganizationEntity organization = account.getOrganization();
        try {
            final String accountKey = this.idEncryptor.getKey(account.getId());
            final Cookie accountKeyCookie = this.saasAccountKeyManager.construct(accountKey);
            response.addCookie(accountKeyCookie);
            final String organizationKey = this.idEncryptor.getKey(organization.getId());
            final Cookie organizationKeyCookie = this.saasOrganizationKeyManager.construct(organizationKey);
            response.addCookie(organizationKeyCookie);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        } finally {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
