package org.testingTool.controllers;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> c970b3f (feat: update controllers, security config, renamed user field in user answer entity)
=======
import lombok.RequiredArgsConstructor;
>>>>>>> a2824b4 (chore: remove field injections, reformat code)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.testingTool.repository.AdminRepository;
=======
=======
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> a2824b4 (chore: remove field injections, reformat code)
import org.testingTool.repository.UserRepository;
>>>>>>> c970b3f (feat: update controllers, security config, renamed user field in user answer entity)

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequiredArgsConstructor
public class AdminPanelController {

<<<<<<< HEAD
<<<<<<< HEAD
  @Autowired private AdminRepository adminRepository;
=======
  @Autowired
  private UserRepository userRepository;
>>>>>>> c970b3f (feat: update controllers, security config, renamed user field in user answer entity)
=======
  private final UserRepository userRepository;
>>>>>>> a2824b4 (chore: remove field injections, reformat code)

  @GetMapping("/")
  public String admin() {
    return "admin_panel_index";
  }
}
