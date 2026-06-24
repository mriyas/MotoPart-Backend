package org.motopart.cloud.repository;

import org.motopart.cloud.entity.Part;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartRepository extends JpaRepository<Part, Long> {
    List<Part> findByMakerIdAndModelIdAndYear(String makerId, String modelId, String year, Pageable pageable);
}
