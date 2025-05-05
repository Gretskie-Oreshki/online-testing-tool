package org.testingTool.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.testingTool.dto.UserAnswerDto;
import org.testingTool.model.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
    TestMapperResolver.class,
    QuestionMapperResolver.class,
    AnswerMapperResolver.class,
    UserMapperResolver.class
})
public interface UserAnswerMapper {

  @Mapping(source = "testId", target = "test", qualifiedByName = "testById")
  @Mapping(source = "questionId", target = "question", qualifiedByName = "questionById")
  @Mapping(source = "answerId", target = "answer", qualifiedByName = "answerById")
  @Mapping(source = "userId", target = "user", qualifiedByName = "userById")
  UserAnswerEntity toEntity(UserAnswerDto dto);

  List<UserAnswerEntity> toEntityList(List<UserAnswerDto> dtos);
}
