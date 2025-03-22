package org.testingTool.controllers;

import org.testingTool.model.Guest;
import org.testingTool.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuestController {
  @Autowired
  private GuestRepository guestRepository;

  @GetMapping("/guest")
  public String account(@RequestParam(value = "id") Long id, Model model) {
    Guest guest = guestRepository.findById(id).orElseThrow(() -> new RuntimeException("Guest does not exist"));
    model.addAttribute("name", guest.getID());
    return "guest";
  }
}
