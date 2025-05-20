package org.testingTool.controllers;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.testingTool.dto.TestDTO;
import org.testingTool.repository.MaterialRepository;
import org.testingTool.services.TestService;

@Controller
@RequestMapping("/test/constructor")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequiredArgsConstructor
public class TestCreationController {

  private final TestService testService;
  private final MaterialRepository materialRepository;

  @GetMapping
  public String showConstructor(Model model) {
    model.addAttribute("test", new TestDTO());
    model.addAttribute("materials", materialRepository.findAll());
    return "create_test";
  }

  @PostMapping
  public String saveTest(
      @ModelAttribute("test") TestDTO testDTO,
      @RequestParam("materialIds") List<Long> materialsIds) {
    testService.saveTestFromForm(testDTO, materialsIds);
    return "redirect:/test/constructor/success";
  }

  @GetMapping("/success")
  public String showSuccessPage() {
    return "success";
  }
}
