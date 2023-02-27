package com.github.ahuangjm.spring.boot.react.starter.managers;

import org.springframework.stereotype.Component;

@Component
public class SaasAccountKeyManager extends CookieManager {
    @Override
    public String getName() {
        return "SAK";
    }
}
