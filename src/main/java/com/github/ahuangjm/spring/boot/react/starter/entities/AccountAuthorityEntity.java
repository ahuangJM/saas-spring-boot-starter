package com.github.ahuangjm.spring.boot.react.starter.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "account_authorities")
@Table
public class AccountAuthorityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private char[] authority;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private AccountEntity account;
}
