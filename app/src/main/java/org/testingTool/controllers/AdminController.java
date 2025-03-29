package org.testingTool.controllers;

import org.testingTool.model.AdminEntity;
import org.testingTool.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
  @Autowired
  private AdminRepository adminRepository;

  @GetMapping("/admin")
  public String admin(@RequestParam(value = "id") Long id, Model model) {
    AdminEntity admin = adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin does not exist"));
    return "admin";
  }
}
