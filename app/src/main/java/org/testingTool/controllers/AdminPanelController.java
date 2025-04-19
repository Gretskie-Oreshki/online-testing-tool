package org.testingTool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.testingTool.repository.AdminRepository;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminPanelController {

  @Autowired private AdminRepository adminRepository;

  @GetMapping("/")
  public String admin() {
    return "admin_panel_index";
  }
}
