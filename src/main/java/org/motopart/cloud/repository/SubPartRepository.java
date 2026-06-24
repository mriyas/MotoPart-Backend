package org.motopart.cloud.repository;

import org.motopart.cloud.entity.SubPart;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubPartRepository extends JpaRepository<SubPart, Long> {
    List<SubPart> findByMakerIdAndModelIdAndYearAndPartId(
            String makerId, String modelId, String year, String partId, Pageable pageable);
}
