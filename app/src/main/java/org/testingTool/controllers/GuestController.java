package org.testingTool.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.testingTool.repository.UserRepository;

@Controller
@RequestMapping("/guest")
@PreAuthorize("hasAuthority('ROLE_USER')")
@RequiredArgsConstructor
public class GuestController {

  private final UserRepository userRepository;

  @GetMapping("/")
  public String guests() {
    return "guest_index";
  }
}
