package org.testingTool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.testingTool.model.AdminEntity;
import org.testingTool.model.GuestEntity;
import org.testingTool.services.AppService;

@Controller
@RequestMapping("/app-controller")
public class AppController {

  @Autowired
  private AppService service;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("message", "this is /app-controller/index");
    return "index";
  }

  @PostMapping("/new-admin")
  public String addAdmin(@RequestBody AdminEntity admin) {
    service.addAdmin(admin);
    return "admin_added";
  }

  @PostMapping("/new-guest")
  public String addGuest(@RequestBody GuestEntity guest) {
    service.addGuest(guest);
    return "guest_added";
  }
}
