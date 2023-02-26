package com.github.ahuangjm.spring.boot.react.starter.repositories;

import com.github.ahuangjm.spring.boot.react.starter.entities.AccountAuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountAuthorityEntityRepository extends JpaRepository<AccountAuthorityEntity, Long> {
}
