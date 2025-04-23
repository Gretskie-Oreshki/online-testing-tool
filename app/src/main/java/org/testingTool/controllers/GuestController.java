package org.testingTool.controllers;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> c970b3f (feat: update controllers, security config, renamed user field in user answer entity)
=======
import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
>>>>>>> a2824b4 (chore: remove field injections, reformat code)
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> cf25b3c (chore: spotlessApply)
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.testingTool.repository.GuestRepository;
=======
=======
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> a2824b4 (chore: remove field injections, reformat code)
import org.testingTool.repository.UserRepository;
>>>>>>> c970b3f (feat: update controllers, security config, renamed user field in user answer entity)

@Controller
@RequestMapping("/guest")
@PreAuthorize("hasAuthority('ROLE_USER')")
@RequiredArgsConstructor
public class GuestController {

<<<<<<< HEAD
<<<<<<< HEAD
  @Autowired private GuestRepository guestRepository;
=======
  @Autowired
  private UserRepository userRepository;
>>>>>>> c970b3f (feat: update controllers, security config, renamed user field in user answer entity)
=======
  private final UserRepository userRepository;
>>>>>>> a2824b4 (chore: remove field injections, reformat code)

  @GetMapping("/")
  public String guests() {
    return "guest_index";
  }
}
