package org.motopart.cloud.repository;

import org.motopart.cloud.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {

    List<Post> findByItemTittleContainingIgnoreCaseOrItemDescriptionContainingIgnoreCase(
            String title, String description, Pageable pageable);
}
