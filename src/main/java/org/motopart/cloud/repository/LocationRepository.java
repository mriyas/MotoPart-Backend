package org.motopart.cloud.repository;

import org.motopart.cloud.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
