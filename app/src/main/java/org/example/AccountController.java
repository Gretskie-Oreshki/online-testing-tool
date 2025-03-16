package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class AccountController {
  @GetMapping("/account")
  public String account(@RequestParam(value = "name", defaultValue = "World") String name, Model model) {
    model.addAttribute("name", name);
    return "account";
  }
}
