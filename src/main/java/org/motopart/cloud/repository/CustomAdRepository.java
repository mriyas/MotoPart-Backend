package org.motopart.cloud.repository;

import org.motopart.cloud.entity.CustomAd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomAdRepository extends JpaRepository<CustomAd, Long> {
}
