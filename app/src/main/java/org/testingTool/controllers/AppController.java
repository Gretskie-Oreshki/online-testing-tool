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

<<<<<<< HEAD
<<<<<<< HEAD
  @Autowired private AppService service;
=======
  @Autowired
  private UserService service;
>>>>>>> c970b3f (feat: update controllers, security config, renamed user field in user answer entity)
=======
  private final UserService service;
>>>>>>> a2824b4 (chore: remove field injections, reformat code)

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
