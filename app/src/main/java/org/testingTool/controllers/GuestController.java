package org.testingTool.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.testingTool.repository.UserRepository;

@Controller
@RequestMapping("/guest")
@PreAuthorize("hasAuthority('ROLE_USER')")
public class GuestController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/")
  public String guests() {
    return "guest_index";
  }
}
