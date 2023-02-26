package com.github.ahuangjm.spring.boot.react.starter.repositories;

import com.github.ahuangjm.spring.boot.react.starter.entities.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationEntityRepository extends JpaRepository<OrganizationEntity, Long> {
}
