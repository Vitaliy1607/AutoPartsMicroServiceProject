package com.parts.userrestapi.repository;

import com.parts.userrestapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsById(Long id);
}
