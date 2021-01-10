package com.parts.userrestapi.repository;

import com.parts.userrestapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsById(Long id);

    @Query(value = "SELECT u from UserEntity u where u.isDeleted=false ")
    List<UserEntity> getAllActiveUsers();
}
