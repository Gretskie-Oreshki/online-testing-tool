package org.testingTool.controllers;

import org.testingTool.model.Admin;
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
    Admin admin = adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin does not exist"));
    model.addAttribute("name", admin.getName());
    model.addAttribute("email", admin.getEmail());
    model.addAttribute("phone_number", admin.getPhoneNumber());
    return "admin";
  }
}
