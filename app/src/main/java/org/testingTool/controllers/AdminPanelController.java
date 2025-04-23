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
import org.testingTool.repository.AdminRepository;
=======
import org.testingTool.repository.UserRepository;
>>>>>>> c970b3f (feat: update controllers, security config, renamed user field in user answer entity)

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminPanelController {

<<<<<<< HEAD
  @Autowired private AdminRepository adminRepository;
=======
  @Autowired
  private UserRepository userRepository;
>>>>>>> c970b3f (feat: update controllers, security config, renamed user field in user answer entity)

  @GetMapping("/")
  public String admin() {
    return "admin_panel_index";
  }
}
