package org.testingTool.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutPageController {
  @GetMapping("/about")
  public String about(Model model) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    boolean isAuthenticated = authentication != null && authentication.isAuthenticated() &&
                                  !authentication.getPrincipal().equals("anonymousUser");
    model.addAttribute("isAuthenticated", isAuthenticated);
    return "about";
  }
}
