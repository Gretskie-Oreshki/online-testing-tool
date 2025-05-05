package org.testingTool.mapper;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import org.testingTool.model.AnswerEntity;
import org.testingTool.repository.AnswerRepository;

@Component
@RequiredArgsConstructor
public class AnswerMapperResolver {

  private final AnswerRepository answerRepository;

  @Named("answerById")
  public AnswerEntity resolve(Long id) {
    return answerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Answer not found: " + id));
  }
}
