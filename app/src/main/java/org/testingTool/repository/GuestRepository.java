package org.testingTool.repository;

import org.springframework.data.repository.CrudRepository;
import org.testingTool.model.GuestEntity;

public interface GuestRepository extends CrudRepository<GuestEntity, Long> {}
