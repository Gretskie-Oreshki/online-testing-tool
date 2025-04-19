package org.testingTool.repository;

import org.springframework.data.repository.CrudRepository;
import org.testingTool.model.AdminEntity;

public interface AdminRepository extends CrudRepository<AdminEntity, Long> {}
