package org.example.repository;

import org.example.model.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface TestRepository extends CrudRepository<Test, Long> {
}
