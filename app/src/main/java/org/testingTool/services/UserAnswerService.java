package org.testingTool.services;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.testingTool.dto.UserAnswerDto;
import org.testingTool.dto.UserAnswerFormDto;
import org.testingTool.mapper.UserAnswerMapper;
import org.testingTool.model.QuestionEntity;
import org.testingTool.model.TestEntity;
import org.testingTool.model.UserAnswerEntity;
import org.testingTool.model.UserTestAccessEntity;
import org.testingTool.model.AnswerEntity;
import org.testingTool.repository.UserAnswerRepository;
import org.testingTool.repository.UserTestAccessRepository;

@Service
@RequiredArgsConstructor
public class UserAnswerService {

  private final TestService testService;
  private final UserAnswerRepository userAnswerRepository;
  private final UserAnswerMapper userAnswerMapper;
  private final UserTestAccessRepository userTestAccessRepository;
  private final UserTestAccessService userTestAccessService;

  @Transactional
  public void saveAnswers(UserAnswerFormDto formDto, Long userId) {
    TestEntity test = testService.getTestById(formDto.getTestId());
    UserTestAccessEntity access = userTestAccessService.getAccessOrThrow(userId, test);

    List<UserAnswerDto> answers = formDto.getAnswers();
    Long testId = test.getId();

    validateAnswersAgainstTest(test, answers);

    answers.forEach(
        answer -> {
          answer.setUserId(userId);
          answer.setTestId(testId);
        });

    List<UserAnswerEntity> entities = userAnswerMapper.toEntityList(answers);
    userAnswerRepository.saveAll(entities);

    access.setIsPassed(true);
    access.setDatePassed(LocalDateTime.now());
    userTestAccessRepository.save(access);
  }

  private void validateAnswersAgainstTest(TestEntity test, List<UserAnswerDto> answers) {
    Set<Long> testQuestionIds =
        test.getQuestions().stream().map(QuestionEntity::getId).collect(Collectors.toSet());

    Set<Long> answeredQuestionIds =
        answers.stream().map(UserAnswerDto::getQuestionId).collect(Collectors.toSet());

    if (!answeredQuestionIds.containsAll(testQuestionIds)) {
      throw new IllegalArgumentException("Вы ответили не на все вопросы теста");
    }

    Map<Long, Set<Long>> questionToAnswerIds =
        test.getQuestions().stream()
            .collect(
                Collectors.toMap(
                    QuestionEntity::getId,
                    q ->
                        q.getAnswers().stream()
                            .map(AnswerEntity::getId)
                            .collect(Collectors.toSet())));

    for (UserAnswerDto answer : answers) {
      Long questionId = answer.getQuestionId();
      Long answerId = answer.getAnswerId();

      if (!questionToAnswerIds.containsKey(questionId)) {
        throw new IllegalArgumentException("Вопрос #" + questionId + " не принадлежит тесту");
      }

      if (!questionToAnswerIds.get(questionId).contains(answerId)) {
        throw new IllegalArgumentException(
            "Ответ #" + answerId + " не принадлежит вопросу #" + questionId);
      }
    }
  }
}
