package org.testingTool.repository;

import org.springframework.data.repository.CrudRepository;
import org.testingTool.model.Result;

public interface ResultRepository extends CrudRepository<Result, Long> {
}
