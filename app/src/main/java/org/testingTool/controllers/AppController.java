package org.testingTool.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.testingTool.model.UserEntity;
import org.testingTool.services.UserService;

@Controller
@RequestMapping("/app-controller")
@RequiredArgsConstructor
public class AppController {

  private final UserService service;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("message", "this is /app-controller/index");
    return "index";
  }

  @PostMapping("/user")
  public String addUser(@RequestBody UserEntity user) {
    service.addUser(user);
    return "admin_added"; // TODO: rename html
  }
}
