package org.testingTool.repository;

import org.springframework.data.repository.CrudRepository;
import org.testingTool.model.UserTestAccessEntity;

public interface UserTestAccessRepository extends CrudRepository<UserTestAccessEntity, Long> {
  boolean existsByUser_UidAndTest_IdAndIsPassedFalse(String uid, Long testId);
}
