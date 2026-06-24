package org.motopart.cloud.repository;

import org.motopart.cloud.entity.AppRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRegistrationRepository extends JpaRepository<AppRegistration, Long> {
}
