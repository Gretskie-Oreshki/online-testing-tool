package org.testingTool.repository;

import org.springframework.data.repository.CrudRepository;
import org.testingTool.model.UserAnswerEntity;

public interface UserAnswerRepository extends CrudRepository<UserAnswerEntity, Long> {}
