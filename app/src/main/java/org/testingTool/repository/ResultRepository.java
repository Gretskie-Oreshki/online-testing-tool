package org.testingTool.repository;

import org.springframework.data.repository.CrudRepository;
import org.testingTool.model.ResultEntity;

public interface ResultRepository extends CrudRepository<ResultEntity, Long> {}
