package org.motopart.cloud.repository;

import org.motopart.cloud.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByMobileAndAppId(String mobile, String appId);
    Optional<UserEntity> findByMobile(String mobile);
}
