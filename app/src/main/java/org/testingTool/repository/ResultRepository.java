package org.testingTool.repository;

import org.testingTool.model.ResultEntity;
import org.springframework.data.repository.CrudRepository;

public interface ResultRepository extends CrudRepository<ResultEntity, Long> {
}
