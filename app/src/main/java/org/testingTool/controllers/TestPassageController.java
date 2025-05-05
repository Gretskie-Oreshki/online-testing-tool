package org.testingTool.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.testingTool.model.TestEntity;
import org.testingTool.services.TestService;


@Controller
@RequiredArgsConstructor
@RequestMapping("/tests")
public class TestPassageController {

  private final TestService testService;

  @GetMapping("/{id}")
  public String testPassage(@PathVariable Long id, Model model) {
    TestEntity test = testService.getTestById(id);
    model.addAttribute("test", test);
    return "test";
  }
}
