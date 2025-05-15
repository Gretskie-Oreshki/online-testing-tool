package org.testingTool.controllers;

import java.security.Principal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.testingTool.model.UserEntity;
import org.testingTool.model.UserTestAccessEntity;
import org.testingTool.repository.UserRepository;
import org.testingTool.repository.UserTestAccessRepository;

@Controller
@RequestMapping("/guest")
@RequiredArgsConstructor
public class GuestController {

  private final UserRepository userRepository;
  private final UserTestAccessRepository accessRepository;

  @GetMapping("/")
  public String guests(Model model, Principal principal) {
    UserEntity user = userRepository.findByUid(principal.getName()).orElseThrow();
    List<UserTestAccessEntity> accesses = accessRepository.findAllByUser(user);

    System.out.println(user.getUid());
    System.out.println(accesses);

    model.addAttribute("accesses", accesses);
    return "guest_index";
  }
}
