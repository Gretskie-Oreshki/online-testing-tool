package org.testingTool.controllers;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.testingTool.model.Role;
import org.testingTool.model.TestEntity;
import org.testingTool.model.UserEntity;
import org.testingTool.model.UserTestAccessEntity;
import org.testingTool.repository.TestRepository;
import org.testingTool.repository.UserRepository;
import org.testingTool.repository.UserTestAccessRepository;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequiredArgsConstructor
public class AdminPanelController {
  private final UserRepository userRepository;
  private final TestRepository testRepository;
  private final UserTestAccessRepository userTestAccessRepository;

  @GetMapping("/")
  public String admin(Model model) {
    Iterable<TestEntity> tests = testRepository.findAll();
    List<UserEntity> users =
        userRepository.findAll().stream().filter(user -> user.getRole() == Role.GUEST).toList();
    List<UserTestAccessEntity> accesses = new ArrayList<>();
    for (UserEntity user : users) {
      UserTestAccessEntity access =
          userTestAccessRepository
              .findByUserId(user.getId())
              .orElseThrow(() -> new IllegalArgumentException());
      accesses.add(access);
    }

    model.addAttribute("tests", tests);
    model.addAttribute("accesses", accesses);
    return "admin_panel_index";
  }
}
