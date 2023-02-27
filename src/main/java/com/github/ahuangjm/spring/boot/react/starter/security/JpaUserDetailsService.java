package com.github.ahuangjm.spring.boot.react.starter.security;

import com.github.ahuangjm.spring.boot.react.starter.entities.AccountAuthorityEntity;
import com.github.ahuangjm.spring.boot.react.starter.entities.AccountEntity;
import com.github.ahuangjm.spring.boot.react.starter.models.Account;
import com.github.ahuangjm.spring.boot.react.starter.repositories.AccountEntityRepository;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaUserDetailsService implements UserDetailsService {
    private final AccountEntityRepository accountEntityRepository;

    public JpaUserDetailsService(final AccountEntityRepository accountEntityRepository) {
        this.accountEntityRepository = accountEntityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final Optional<AccountEntity> accountEntityOptional = this.accountEntityRepository.findByEmail(username.toCharArray());
        final AccountEntity accountEntity = accountEntityOptional
                .orElseThrow(() -> new AuthenticationCredentialsNotFoundException("Cannot find user with the provided username."));

        final String password = String.valueOf(accountEntity.getPassword());
        final List<AccountAuthorityEntity> accountAuthorities = accountEntity.getAuthorities();
        final List<GrantedAuthority> authorities = accountAuthorities.stream()
                .map(accountAuthorityEntity -> {
                    final String authority = String.valueOf(accountAuthorityEntity.getAuthority());
                    return new SimpleGrantedAuthority(authority);
                })
                .collect(Collectors.toList());
        final String role = accountEntity.getRole().name();
        final boolean disabled = !accountEntity.isEnabled();

        final UserDetails userdetails = Account.builder()
                .username(username)
                .password(password)
                .authorities(authorities)
                .roles(role)
                .disabled(disabled)
                .build();
        return new Account(accountEntity.getId(), accountEntity.getOrganization(), userdetails);
    }
}
