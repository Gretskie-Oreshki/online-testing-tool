package org.testingTool.repository;

import org.springframework.data.repository.CrudRepository;
import org.testingTool.model.Guest;

public interface GuestRepository extends CrudRepository<Guest, Long> {
}
