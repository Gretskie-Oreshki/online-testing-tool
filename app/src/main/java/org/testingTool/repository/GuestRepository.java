package org.testingTool.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.testingTool.model.GuestEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface GuestRepository extends CrudRepository<GuestEntity, Long> {

  @Query("SELECT g FROM GuestEntity g WHERE g.accountExpirationDate < :now")
  List<GuestEntity> findExpired(@Param("now") LocalDateTime now);
}
