package com.github.ahuangjm.spring.boot.react.starter.entities;

import com.github.ahuangjm.spring.boot.react.starter.enums.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "accounts")
@Table
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private char[] email;
    private char[] password;
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_authority_id", referencedColumnName = "id")
    private List<AccountAuthorityEntity> authorities;
}
