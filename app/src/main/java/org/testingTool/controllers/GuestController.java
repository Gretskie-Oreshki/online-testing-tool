package org.testingTool.controllers;

<<<<<<< HEAD
=======
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> c970b3f (feat: update controllers, security config, renamed user field in user answer entity)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.testingTool.repository.GuestRepository;
=======
import org.testingTool.repository.UserRepository;
>>>>>>> c970b3f (feat: update controllers, security config, renamed user field in user answer entity)

@Controller
@RequestMapping("/guest")
@PreAuthorize("hasAuthority('ROLE_USER')")
public class GuestController {

<<<<<<< HEAD
  @Autowired private GuestRepository guestRepository;
=======
  @Autowired
  private UserRepository userRepository;
>>>>>>> c970b3f (feat: update controllers, security config, renamed user field in user answer entity)

  @GetMapping("/")
  public String guests() {
    return "guest_index";
  }
}
