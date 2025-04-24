package org.testingTool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.testingTool.dataTransferObjects.TestDataTransferObject;
import org.testingTool.model.TestEntity;
import org.testingTool.repository.TestRepository;

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
    model.addAttribute("test", new TestDataTransferObject());
    return "create_test";
  }

  @PostMapping
  public String saveTest(@ModelAttribute("test") TestDataTransferObject testDTO) {
    TestEntity test = new TestEntity();
    test.setName(testDTO.getTestName());
    test.setQuestions(testDTO.getListOfQuestions());
    testRepository.save(test);
    return "redirect:/test/constructor/success";
  }

  @GetMapping("/success")
  public String showSuccessPage() {
    return "success";
  }
}
