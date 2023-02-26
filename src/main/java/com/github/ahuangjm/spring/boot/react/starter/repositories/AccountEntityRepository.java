package com.github.ahuangjm.spring.boot.react.starter.repositories;

import com.github.ahuangjm.spring.boot.react.starter.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountEntityRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByEmail(final char[] email);
}
