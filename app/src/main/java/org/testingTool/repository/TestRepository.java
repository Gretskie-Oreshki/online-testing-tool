package org.testingTool.repository;

import org.testingTool.model.TestEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<TestEntity, Long> {
}
