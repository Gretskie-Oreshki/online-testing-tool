package org.testingTool.controllers;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.testingTool.dto.UserFormDto;
import org.testingTool.model.Role;
import org.testingTool.model.TestEntity;
import org.testingTool.model.UserEntity;
import org.testingTool.model.UserTestAccessEntity;
import org.testingTool.repository.TestRepository;
import org.testingTool.repository.UserRepository;
import org.testingTool.repository.UserTestAccessRepository;
import org.testingTool.services.UserService;
import org.testingTool.services.UserTestAccessService;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequiredArgsConstructor
public class AdminPanelController {
  private final UserRepository userRepository;
  private final TestRepository testRepository;
  private final UserTestAccessRepository userTestAccessRepository;

  private final UserService userService;
  private final UserTestAccessService userTestAccessService;

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
    return "admin/index";
  }

  @GetMapping("/add-guest")
  public String addGuestPage(Model model) {
    Iterable<TestEntity> tests = testRepository.findAll();

    model.addAttribute("tests", tests);
    return "admin/add_guest";
  }

  @PostMapping("/add-guest")
  public String addGuest(@ModelAttribute UserFormDto formDto) {
    UserEntity guest = userService.newGuestEntity(formDto.getPassword());
    TestEntity test =
        testRepository
            .findById(formDto.getTestId())
            .orElseThrow(() -> new IllegalArgumentException());

    guest = userService.saveUser(guest);
    userTestAccessService.grantAccess(guest, test);

    return "redirect:/admin/";
  }

  @PostMapping("/delete-guest/{uid}")
  public String deleteGuest(@PathVariable String uid) {
    UserEntity guest =
        userRepository.findByUid(uid).orElseThrow(() -> new IllegalArgumentException());
    UserTestAccessEntity access =
        userTestAccessRepository
            .findByUserId(guest.getId())
            .orElseThrow(() -> new IllegalArgumentException());

    userTestAccessRepository.delete(access);
    userRepository.delete(guest);

    return "redirect:/admin/";
  }

  @GetMapping("/edit-guest/{uid}")
  public String editGuestPage(@PathVariable String uid, Model model) {
    UserEntity guest =
        userRepository.findByUid(uid).orElseThrow(() -> new IllegalArgumentException());
    Iterable<TestEntity> tests = testRepository.findAll();

    model.addAttribute("uid", uid);
    model.addAttribute("guest", guest);
    model.addAttribute("tests", tests);
    return "admin/edit_guest";
  }

  @PostMapping("/edit-guest/{uid}")
  public String editGuest(@PathVariable String uid, @ModelAttribute UserFormDto formDto) {
    UserEntity guest =
        userRepository.findByUid(uid).orElseThrow(() -> new IllegalArgumentException());
    TestEntity test =
        testRepository
            .findById(formDto.getTestId())
            .orElseThrow(() -> new IllegalArgumentException());
    UserTestAccessEntity access =
        userTestAccessRepository
            .findByUserId(guest.getId())
            .orElseThrow(() -> new IllegalArgumentException());

    guest.setPassword(formDto.getPassword());
    access.setTest(test);

    userService.saveUser(guest);
    userTestAccessRepository.save(access);

    return "redirect:/admin/";
  }
}
