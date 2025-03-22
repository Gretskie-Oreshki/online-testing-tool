package org.testingTool.repository;

import org.springframework.data.repository.CrudRepository;
import org.testingTool.model.Guest;

public interface AdminRepository extends CrudRepository<Guest, Long> {
}
