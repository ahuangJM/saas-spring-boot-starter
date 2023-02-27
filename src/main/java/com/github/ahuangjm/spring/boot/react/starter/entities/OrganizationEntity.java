package com.github.ahuangjm.spring.boot.react.starter.entities;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "organizations")
@Table
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private char[] name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<AccountEntity> accounts;
}
