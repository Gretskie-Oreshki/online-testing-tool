package org.testingTool.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.testingTool.model.MaterialEntity;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {
  Page<MaterialEntity> findByFileNameContainingIgnoreCase(String fileName, Pageable pageable);
}
