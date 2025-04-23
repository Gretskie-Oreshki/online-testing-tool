package org.testingTool.repository;

import org.springframework.data.repository.CrudRepository;
import org.testingTool.model.TestEntity;

public interface TestRepository extends CrudRepository<TestEntity, Long> {}
