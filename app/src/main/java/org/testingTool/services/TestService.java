package org.testingTool.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.testingTool.model.TestEntity;
import org.testingTool.repository.TestRepository;

@Service
@RequiredArgsConstructor
public class TestService {

  private final TestRepository testRepository;

  public TestEntity getTestById(Long id) {
    return testRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Test with id " + id + " not found"));
  }
}
