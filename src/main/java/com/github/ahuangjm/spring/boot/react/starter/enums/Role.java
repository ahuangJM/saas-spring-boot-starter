package com.github.ahuangjm.spring.boot.react.starter.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    GUEST("guest"), USER("user"), ADMIN("admin"), SUPER_ADMIN("super_admin");

    private final String value;
}
