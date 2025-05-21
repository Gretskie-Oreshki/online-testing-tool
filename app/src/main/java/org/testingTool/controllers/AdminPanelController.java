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
import org.testingTool.model.TestEntity;
import org.testingTool.model.UserEntity;
import org.testingTool.model.UserTestAccessEntity;
import org.testingTool.repository.TestRepository;
import org.testingTool.repository.UserRepository;
import org.testingTool.repository.UserTestAccessRepository;
import org.testingTool.services.TestService;
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
  private final TestService testService;
  private final UserTestAccessService userTestAccessService;

  @GetMapping("/")
  public String admin(Model model) {
    Iterable<TestEntity> tests = testRepository.findAll();
    List<UserEntity> guests = userService.findAllGuests();

    List<UserTestAccessEntity> accesses = new ArrayList<>();
    for (UserEntity guest : guests) {
      UserTestAccessEntity access = userTestAccessService.findAccessOrThrow(guest.getId());
      accesses.add(access);
    }

    model.addAttribute("tests", tests);
    model.addAttribute("accesses", accesses);
    return "admin/index";
  }

  @GetMapping("/delete-test/{id}")
  public String deleteTestPage(@PathVariable Long id, Model model) {
    TestEntity test = testService.getTestById(id);

    model.addAttribute("test", test);
    return "admin/delete_test";
  }

  @PostMapping("/delete-test/{id}")
  public String deleteTest(@PathVariable Long id) {
    TestEntity test = testService.getTestById(id);

    testRepository.delete(test);
    List<UserTestAccessEntity> accesses = userTestAccessRepository.findAllByTest(test);
    for (UserTestAccessEntity access : accesses) {
      userRepository.delete(access.getUser());
    }
    userTestAccessRepository.deleteAll(accesses);

    return "redirect:/admin/";
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
    TestEntity test = testService.getTestById(formDto.getTestId());

    guest = userService.encodeUser(guest);
    guest = userRepository.save(guest);
    UserTestAccessEntity access = userTestAccessService.newAccessEntity(guest, test);
    userTestAccessRepository.save(access);

    return "redirect:/admin/";
  }

  @GetMapping("/delete-guest/{uid}")
  public String deleteGuestPage(@PathVariable String uid, Model model) {
    model.addAttribute("uid", uid);
    return "admin/delete_guest";
  }

  @PostMapping("/delete-guest/{uid}")
  public String deleteGuest(@PathVariable String uid) {
    UserEntity guest = userService.findGuestOrThrow(uid);
    UserTestAccessEntity access = userTestAccessService.findAccessOrThrow(guest.getId());

    userTestAccessRepository.delete(access);
    userRepository.delete(guest);

    return "redirect:/admin/";
  }

  @GetMapping("/edit-guest/{uid}")
  public String editGuestPage(@PathVariable String uid, Model model) {
    UserEntity guest = userService.findGuestOrThrow(uid);
    Iterable<TestEntity> tests = testRepository.findAll();

    model.addAttribute("uid", uid);
    model.addAttribute("guest", guest);
    model.addAttribute("tests", tests);
    return "admin/edit_guest";
  }

  @PostMapping("/edit-guest/{uid}")
  public String editGuest(@PathVariable String uid, @ModelAttribute UserFormDto formDto) {
    UserEntity guest = userService.findGuestOrThrow(uid);
    TestEntity test = testService.getTestById(formDto.getTestId());
    UserTestAccessEntity access = userTestAccessService.findAccessOrThrow(guest.getId());

    guest.setPassword(formDto.getPassword());
    guest = userService.encodeUser(guest);
    access.setTest(test);

    userRepository.save(guest);
    userTestAccessRepository.save(access);

    return "redirect:/admin/";
  }
}
