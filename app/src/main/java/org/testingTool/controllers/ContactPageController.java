package org.testingTool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactPageController {
  @GetMapping("/contact")
  public String contact() {
    return "contact";
  }
}
