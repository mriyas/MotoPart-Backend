package org.motopart.cloud.repository;

import org.motopart.cloud.entity.OtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<OtpEntity, Long> {
    Optional<OtpEntity> findTopByUserPhoneAndAppIdOrderByCreatedAtDesc(String userPhone, String appId);
}
