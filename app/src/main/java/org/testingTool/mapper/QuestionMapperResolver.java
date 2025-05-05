package org.testingTool.mapper;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import org.testingTool.model.QuestionEntity;
import org.testingTool.model.TestEntity;
import org.testingTool.repository.QuestionRepository;
import org.testingTool.repository.TestRepository;

@Component
@RequiredArgsConstructor
public class QuestionMapperResolver {

  private final QuestionRepository questionRepository;

  @Named("questionById")
  public QuestionEntity resolve(Long id) {
    return questionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Question not found: " + id));
  }
}
