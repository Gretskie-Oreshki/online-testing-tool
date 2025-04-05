package org.testingTool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.testingTool.model.AdminEntity;

@Controller
public class IndexController {

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("name", "this is index controller");
    return "index";
  }
}
