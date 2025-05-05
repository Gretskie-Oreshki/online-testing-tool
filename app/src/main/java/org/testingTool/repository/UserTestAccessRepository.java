package org.testingTool.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.testingTool.model.UserTestAccessEntity;

import java.util.Optional;

public interface UserTestAccessRepository extends CrudRepository<UserTestAccessEntity, Long> {
  @Query("SELECT COUNT(uta) > 0 FROM UserTestAccessEntity uta " +
      "WHERE uta.user.id = :userId " +
      "AND uta.test.id = :testId " +
      "AND uta.isPassed = false")
  boolean hasAccess(@Param("userId") Long userId, @Param("testId") Long testId);

  Optional<UserTestAccessEntity> findByUser_IdAndTest_Id(Long userId, Long testId);
}
