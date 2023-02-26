package com.github.ahuangjm.spring.boot.react.starter.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "users")
@Table
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private AccountEntity account;
}
