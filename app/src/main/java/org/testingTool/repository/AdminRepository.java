package org.testingTool.repository;

import org.springframework.data.repository.CrudRepository;
import org.testingTool.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long> {
}
