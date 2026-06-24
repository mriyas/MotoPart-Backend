package org.motopart.cloud.repository;

import org.motopart.cloud.entity.ModelEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
    List<ModelEntity> findByMakerId(String makerId, Pageable pageable);
}
