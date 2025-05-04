package org.testingTool.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.testingTool.model.MaterialEntity;

public interface MaterialRepository extends CrudRepository<MaterialEntity, Long> {
  Page<MaterialEntity> findByFileNameContainingIgnoreCase(String fileName, Pageable pageable);

  Page<MaterialEntity> findAllBy(Pageable pageable);
}
