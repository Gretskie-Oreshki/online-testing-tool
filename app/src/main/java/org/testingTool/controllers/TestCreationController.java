package org.testingTool.controllers;

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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test/constructor")
// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class TestCreationController {
  private final TestRepository testRepository;

  public TestCreationController(TestRepository testRepository) {
    this.testRepository = testRepository;
  }

  @GetMapping
  public String showConstructor(Model model) {
    model.addAttribute("test", new TestDTO());
    return "create_test";
  }

  @PostMapping
  public String saveTest(@ModelAttribute("test") TestDTO testDTO) {
    TestEntity test = new TestEntity();
    test.setName(testDTO.getTestName());

    List<QuestionEntity> questions = new ArrayList<>();

    for (QuestionDTO qDTO : testDTO.getQuestions()) {
      QuestionEntity question = new QuestionEntity();
      question.setName(qDTO.getQuestionName());

      List<AnswerEntity> answers = new ArrayList<>();
      for (AnswerDTO aDTO : qDTO.getAnswers()) {
        AnswerEntity answer = new AnswerEntity();
        answer.setValue(aDTO.getValue());
        answer.setRight(aDTO.isCorrect());
        answer.setQuestion(question);
        answers.add(answer);
      }
      question.setAnswers(answers);
      question.setTest(test);
      questions.add(question);
    }
    test.setQuestions(questions);
    testRepository.save(test);
    return "redirect:/test/constructor/success";
  }

  @GetMapping("/success")
  public String showSuccessPage() {
    return "success";
  }
}
