package org.testingTool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.testingTool.repository.GuestRepository;

@Controller
@RequestMapping("/guest")
@PreAuthorize("hasAuthority('ROLE_USER')")
public class GuestController {

  @Autowired private GuestRepository guestRepository;

  @GetMapping("/")
  public String guests() {
    return "guest_index";
  }
}
