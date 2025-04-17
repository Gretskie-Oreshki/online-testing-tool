package org.testingTool.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.testingTool.repository.TestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.testingTool.repository.UserRepository;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequiredArgsConstructor
public class AdminPanelController {

  private UserRepository userRepository;
  private TestRepository testRepository;

  @GetMapping("/")
  public String admin(Model model) {
    model.addAttribute("tests", testRepository.findAll());
    model.addAttribute("guests", userRepository.findAll());
    return "admin_panel_index";
  }
}
