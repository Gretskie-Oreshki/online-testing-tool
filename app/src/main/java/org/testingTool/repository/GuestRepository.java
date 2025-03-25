package org.testingTool.repository;

import org.testingTool.model.GuestEntity;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<GuestEntity, Long> {
}
