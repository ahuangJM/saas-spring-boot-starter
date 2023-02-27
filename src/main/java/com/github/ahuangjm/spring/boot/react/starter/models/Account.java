package com.github.ahuangjm.spring.boot.react.starter.models;

import com.github.ahuangjm.spring.boot.react.starter.entities.OrganizationEntity;
import lombok.Getter;
import org.springframework.security.core.userdetails.User;

@Getter
public class Account extends User {
    private final long id;
    private final OrganizationEntity organization;

    public Account(
            final long id,
            final OrganizationEntity organization,
            final org.springframework.security.core.userdetails.UserDetails user) {
        super(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),
                user.isAccountNonLocked(),
                user.getAuthorities());
        this.id = id;
        this.organization = organization;
    }

    @Override
    public String toString() {
        return getClass().getName() + " [" +
                "Id=" + this.getId() + ", " +
                "Username=" + this.getUsername() + ", " +
                "Password=[PROTECTED], " +
                "Organization=" + String.valueOf(this.getOrganization().getName()) + ", " +
                "Enabled=" + this.isEnabled() + ", " +
                "AccountNonExpired=" + this.isAccountNonExpired() + ", " +
                "credentialsNonExpired=" + this.isCredentialsNonExpired() + ", " +
                "AccountNonLocked=" + this.isAccountNonLocked() + ", " +
                "Granted Authorities=" + this.getAuthorities() + "]";
    }
}
