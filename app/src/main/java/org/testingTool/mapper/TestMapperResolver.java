package org.testingTool.mapper;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import org.testingTool.model.TestEntity;
import org.testingTool.repository.TestRepository;

@Component
@RequiredArgsConstructor
public class TestMapperResolver {

  private final TestRepository testRepository;

  @Named("testById")
  public TestEntity resolve(Long id) {
    return testRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Test not found: " + id));
  }
}
