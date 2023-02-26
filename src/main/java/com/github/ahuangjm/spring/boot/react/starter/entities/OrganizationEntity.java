package com.github.ahuangjm.spring.boot.react.starter.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "organizations")
@Table
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
}
