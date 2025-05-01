package org.testingTool.repository;

import org.springframework.data.repository.CrudRepository;
import org.testingTool.model.MaterialEntity;

public interface MaterialRepository extends CrudRepository<MaterialEntity, Long> {}
