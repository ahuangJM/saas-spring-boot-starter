package com.github.ahuangjm.spring.boot.react.starter.repositories;

import com.github.ahuangjm.spring.boot.react.starter.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}
