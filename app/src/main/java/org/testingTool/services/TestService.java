package org.testingTool.services;

import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.testingTool.dto.AnswerDTO;
import org.testingTool.dto.QuestionDTO;
import org.testingTool.dto.TestDTO;
import org.testingTool.model.AnswerEntity;
import org.testingTool.model.MaterialEntity;
import org.testingTool.model.QuestionEntity;
import org.testingTool.model.TestEntity;
import org.testingTool.repository.MaterialRepository;
import org.testingTool.repository.TestRepository;

@Service
@RequiredArgsConstructor
public class TestService {

  private final TestRepository testRepository;
  private final MaterialRepository materialRepository;

  public TestEntity getTestById(Long id) {
    return testRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Test with id " + id + " not found"));
  }

  public void saveTestFromForm(TestDTO testDTO, List<Long> materialsIds) {
    TestEntity testEntity = new TestEntity();
    testEntity.setName(testDTO.getName());

    List<QuestionEntity> questions = new ArrayList<>();

    for (QuestionDTO qDTO : testDTO.getQuestions()) {
      QuestionEntity questionEntity = new QuestionEntity();
      questionEntity.setName(qDTO.getQuestionName());
      int rightAnswer = qDTO.getRightAnswer();

      List<AnswerEntity> answers = new ArrayList<>();
      for (AnswerDTO aDTO : qDTO.getAnswers()) {
        AnswerEntity answer = new AnswerEntity();
        answer.setValue(aDTO.getValue());
        answer.setRight(false);
        answer.setQuestion(questionEntity);
        answers.add(answer);
      }
      answers.get(rightAnswer).setRight(true);
      questionEntity.setAnswers(answers);
      questionEntity.setTest(testEntity);
      questions.add(questionEntity);
    }

    testEntity.setQuestions(questions);

    List<MaterialEntity> materials = new ArrayList<>();
    for (Long materialId : materialsIds) {
      if (materialRepository.findById(materialId).isPresent()) {
        materials.add(materialRepository.findById(materialId).get());
      } else {
        throw new IllegalArgumentException("Material with id: " + materialId + " not found");
      }
    }

    testEntity.setMaterials(materials);
    testRepository.save(testEntity);
  }
}
