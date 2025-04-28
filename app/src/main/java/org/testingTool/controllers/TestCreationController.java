package org.testingTool.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.testingTool.dto.AnswerDTO;
import org.testingTool.dto.QuestionDTO;
import org.testingTool.dto.TestDTO;
import org.testingTool.model.AnswerEntity;
import org.testingTool.model.QuestionEntity;
import org.testingTool.model.TestEntity;
import org.testingTool.repository.TestRepository;

@Controller
@RequestMapping("/test/constructor")
// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class TestCreationController {

  @Autowired private TestRepository testRepository;

  @GetMapping
  public String showConstructor(Model model) {
    model.addAttribute("test", new TestDTO());
    return "create_test";
  }

  @PostMapping
  public String saveTest(@ModelAttribute("test") TestDTO testDTO) {
    TestEntity testEntity = new TestEntity();
    testEntity.setName(testDTO.getTestName());

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
    testRepository.save(testEntity);
    return "redirect:/test/constructor/success";
  }

  @GetMapping("/success")
  public String showSuccessPage() {
    return "success";
  }
}
