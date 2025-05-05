package org.testingTool.repository;

import org.springframework.data.repository.CrudRepository;
import org.testingTool.model.AnswerEntity;

public interface AnswerRepository extends CrudRepository<AnswerEntity, Long> {
}
