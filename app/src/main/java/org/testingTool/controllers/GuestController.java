package org.testingTool.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.testingTool.model.GuestEntity;
import org.testingTool.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/guest")
public class GuestController {
  @Autowired
  private GuestRepository guestRepository;

  @GetMapping("/")
  public String guest(@RequestParam(value = "id") Long id, Model model) {
    GuestEntity guest = guestRepository.findById(id).orElse(null);
    if (guest == null) {
      model.addAttribute("message", "Guest not found");
      return "guest_index";
    }
    model.addAttribute("name", guest.getGuestID());
    return "guest_index";
  }
}
