package org.testingTool.repository;

import org.springframework.data.repository.CrudRepository;
import org.testingTool.model.QuestionEntity;

public interface QuestionRepository extends CrudRepository<QuestionEntity, Long> {}
